package nakami;

import com.wuxiao.bussiness.model.OrderHeader;
import com.wuxiao.bussiness.model.SysUser;
import com.wuxiao.bussiness.order.dao.OrderHeaderDao;
import com.wuxiao.bussiness.order.model.OrderLineQueryCondition;
import com.wuxiao.bussiness.order.model.OrderLineQueryResult;
import com.wuxiao.bussiness.order.service.OrderService;
import com.wuxiao.bussiness.user.service.SysUserService;
import com.wuxiao.bussiness.user.service.TestService;
import com.wuxiao.bussiness.user.service.impl.SysUserServiceImpl;
import com.wuxiao.config.ConfigIOC;
import com.wuxiao.person.method.ISay;
import com.wuxiao.person.model.Person;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

public class test {

    @Autowired
    private OrderService orderService;
    @Autowired
    private SysUserService sysUserService;

    public void showBeans(ApplicationContext applicationContext) {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }

    /**
     * @param aClass 传入配置类的class类
     * @return
     */
    public ApplicationContext getApplicationContext(Class aClass) {
        return new AnnotationConfigApplicationContext(aClass);
    }

    @Test
    public void TestShowBean() {
        ApplicationContext applicationContext = getApplicationContext(ConfigIOC.class);
        showBeans(applicationContext);

    }

    @Test
    public void testTest() {
        ApplicationContext applicationContext = getApplicationContext(ConfigIOC.class);
        TestService bean = applicationContext.getBean(TestService.class);
        bean.get();
    }

    @Test
    public void testPerson() {
        ApplicationContext applicationContext = getApplicationContext(ConfigIOC.class);
        Person bean = applicationContext.getBean(Person.class);

        System.out.println(bean);
    }

    @Test
    public void testAop() {
        ApplicationContext applicationContext = getApplicationContext(ConfigIOC.class);
        ISay chineseSay = (ISay) applicationContext.getBean("chineseSay");
        ISay englishSay = (ISay) applicationContext.getBean("englishSay");
//        System.out.println(bean);
        chineseSay.say();

        englishSay.say();


    }


//    @Test
//    public void testGetOrderHeader(){
//        ApplicationContext applicationContext = getApplicationContext(ConfigIOC.class);
//        OrderHeaderDao orderHeaderDao = applicationContext.getBean(OrderHeaderDao.class);
//        OrderHeader orderHeaderList = orderHeaderDao.getOrderHeader();
//        System.out.println(orderHeaderList);
//    }

    @Test
    public void TestSelectOrderLinesByCondition() {
        ApplicationContext applicationContext = getApplicationContext(ConfigIOC.class);
        OrderHeaderDao orderHeaderDao = applicationContext.getBean(OrderHeaderDao.class);
        OrderLineQueryCondition condition = new OrderLineQueryCondition();
        condition.setItemCode("00");
        condition.setItemName("卫龙");

        List<OrderLineQueryResult> orderLineQueryResults = orderHeaderDao.selectOrderLinesByCondition(condition);
        System.out.println(orderLineQueryResults);
    }

    @Test
    public void TestInsertUser() {
        ApplicationContext applicationContext = getApplicationContext(ConfigIOC.class);
        showBeans(applicationContext);
        SysUserServiceImpl sysUserService = applicationContext.getBean(SysUserServiceImpl.class);

        SysUser sysUser = new SysUser();
        sysUser.setAddress("上海");
        sysUser.setUserName("wuxiao");
        sysUser.setUserNumber("20016");


        int i = sysUserService.insertUser(sysUser);
        System.out.println("新增的用户id为：" + i);


    }

    @Test
    public void TestUpdateUser() {
        ApplicationContext applicationContext = getApplicationContext(ConfigIOC.class);
        SysUserServiceImpl sysUserService = applicationContext.getBean(SysUserServiceImpl.class);
        SysUser sysUser = new SysUser();
        sysUser.setUserId(14);
        sysUser.setUserName("吴晓4");
        sysUserService.updateUser(sysUser);

    }

    @Test
    public void TestDeleteUser() {
        ApplicationContext applicationContext = getApplicationContext(ConfigIOC.class);
        SysUserServiceImpl sysUserService = applicationContext.getBean(SysUserServiceImpl.class);


        System.out.println("删除了" + sysUserService.deleteUser(16L) + "个数据");

    }

}

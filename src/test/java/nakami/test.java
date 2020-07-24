package nakami;

import com.wuxiao.bussiness.model.OrderHeader;
import com.wuxiao.bussiness.model.SysUser;
import com.wuxiao.bussiness.order.dao.OrderHeaderDao;
import com.wuxiao.bussiness.order.model.OrderLineQueryCondition;
import com.wuxiao.bussiness.order.model.OrderLineQueryResult;
import com.wuxiao.bussiness.order.service.OrderService;
import com.wuxiao.bussiness.user.service.impl.SysUserServiceImpl;
import com.wuxiao.config.ConfigIOC;
import com.wuxiao.person.method.ISay;
import com.wuxiao.person.model.Person;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;
import java.util.List;

public class test {

    @Autowired
    private OrderService orderService;
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
    public void test1() {
        ApplicationContext applicationContext = getApplicationContext(ConfigIOC.class);
        showBeans(applicationContext);

    }

    @Test
    public void testPerson(){
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
    public void TestSelectOrderLinesByCondition(){
        ApplicationContext applicationContext = getApplicationContext(ConfigIOC.class);
        OrderHeaderDao orderHeaderDao = applicationContext.getBean(OrderHeaderDao.class);
        OrderLineQueryCondition condition = new OrderLineQueryCondition();
        condition.setItemCode("00");
        condition.setItemName("卫龙");

        List<OrderLineQueryResult> orderLineQueryResults = orderHeaderDao.selectOrderLinesByCondition(condition);
        System.out.println(orderLineQueryResults);
    }

    @Test
    public void TestInsertUser(){
        ApplicationContext applicationContext = getApplicationContext(ConfigIOC.class);
        SysUserServiceImpl sysUserService = applicationContext.getBean(SysUserServiceImpl.class);
        SysUser sysUser = new SysUser();
        sysUser.setAddress("上海");
        sysUser.setUserName("吴晓");
        sysUser.setUserNumber("20004");


        int i = sysUserService.insertUser(sysUser);
        System.out.println(i);


    }




}

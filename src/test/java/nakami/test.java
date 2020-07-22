package nakami;

import com.wuxiao.config.ConfigIOC;
import com.wuxiao.person.method.ChineseSay;
import com.wuxiao.person.method.ISay;
import com.wuxiao.person.model.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sun.applet.Main;

public class test {

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


}

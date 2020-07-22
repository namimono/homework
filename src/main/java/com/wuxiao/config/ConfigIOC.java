package com.wuxiao.config;


import com.wuxiao.person.aspect.ISayAspect;
import com.wuxiao.person.method.ChineseSay;
import com.wuxiao.person.method.EnglishSay;
import com.wuxiao.person.method.ISay;
import com.wuxiao.person.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class ConfigIOC {

    @Bean
    public Person person(@Qualifier("chineseSay") ISay iSay) {
        return new Person("a", iSay);
    }

    @Bean
    public ISay chineseSay() {
        return new ChineseSay();
    }

    @Bean
    public ISay englishSay() {
        return new EnglishSay();
    }

    @Bean
    public ISayAspect iSayAspect(){
        return new ISayAspect();
    }
}

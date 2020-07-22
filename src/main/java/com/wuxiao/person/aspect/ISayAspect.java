package com.wuxiao.person.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
public class ISayAspect {

    @Pointcut("execution(* com.wuxiao.person.method.*.say(..))")
    public void pointCut(){

    }
    @Before("pointCut()")
    public void before() {
        System.out.println("before<28243>");
    }

    @After("pointCut()")
    public void after() {
        System.out.println("after<28243>");
    }
}

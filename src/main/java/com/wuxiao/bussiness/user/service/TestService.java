package com.wuxiao.bussiness.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @Autowired
    private SysUserService sysUserService;

    public void get(){
        System.out.println(sysUserService);

    }
}

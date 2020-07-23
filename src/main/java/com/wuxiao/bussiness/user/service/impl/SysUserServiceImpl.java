package com.wuxiao.bussiness.user.service.impl;

import com.wuxiao.bussiness.model.SysUser;
import com.wuxiao.bussiness.user.dao.SysUserDao;
import com.wuxiao.bussiness.user.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    SysUserDao sysUserDao;

    public int insertUser(SysUser user) {
        SysUser sysUser = new SysUser();
        sysUser.setAddress("");
        sysUser.setLastUpdateDate(new Date());
        sysUser.setCreationDate(new Date());
        return 0;
    }
}

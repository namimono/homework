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

        user.setLastUpdateDate(new Date());
        user.setCreationDate(new Date());
        user.setObjectVersionNumber(0);
//        设置创建人
        user.setCreatedBy(1);
//        设置最后更新人
        user.setLastUpdatedBy(1);
        return sysUserDao.insertUser(user);
    }
}

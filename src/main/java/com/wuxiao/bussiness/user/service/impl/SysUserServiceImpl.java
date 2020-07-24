package com.wuxiao.bussiness.user.service.impl;

import com.wuxiao.bussiness.model.SysUser;
import com.wuxiao.bussiness.user.dao.SysUserDao;
import com.wuxiao.bussiness.user.service.SysUserService;
import com.wuxiao.utils.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    SysUserDao sysUserDao;


    @Transactional
    public int insertUser(SysUser user) {

        user.setLastUpdateDate(new Date());
        user.setCreationDate(new Date());
        user.setObjectVersionNumber(0);
//        设置创建人
        user.setCreatedBy(1);
//        设置最后更新人
        user.setLastUpdatedBy(1);
        int i = sysUserDao.insertUser(user);
        System.out.println(user.getUserId());

        return i;
    }

    public int updateUser(SysUser user) {
        SysUser sysUser = sysUserDao.selectById(user);
//        更新sysUser
        Utils.copyPropertiesIgnoreNull(user,sysUser);
//        设置最后更新时间和更新人
        sysUser.setLastUpdatedBy(1);
        sysUser.setLastUpdateDate(new Date());
//        mysql乐观锁
        int flag = 0;
        while (flag == 0) {
            flag = sysUserDao.updateUser(sysUser);
        }
        return 0;
    }

    public int deleteUser(Long userId) {
        return sysUserDao.deleteUser(userId);
    }
}

package com.wuxiao.bussiness.user.dao;

import com.wuxiao.bussiness.model.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserDao {
//    5.
    int insertUser(@Param("user") SysUser user);

//    6.

}

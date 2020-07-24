package com.wuxiao.bussiness.user.service;

import com.wuxiao.bussiness.model.SysUser;

public interface SysUserService {
    /**
     * 5.
     * @param user
     * @return
     */
    int insertUser(SysUser user);

    /**
     * 6.
     * @param user
     * @return
     */
    int updateUser(SysUser user);

    /**
     * 7.
     * @param userId
     * @return
     */
    int deleteUser(Long userId);
}

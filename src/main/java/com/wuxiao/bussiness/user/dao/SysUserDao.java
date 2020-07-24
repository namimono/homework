package com.wuxiao.bussiness.user.dao;

import com.wuxiao.bussiness.model.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserDao {
    /**
     * 5.
     * @param user 要插入的对象
     * @return
     */
    int insertUser(@Param("user") SysUser user);

    /**
     * 6.根据userId进行更新
     * @param user 要更新的对象
     * @return
     */
    int updateUser(@Param("user") SysUser user);

    /**
     * 根据userId查询
     * @param user
     * @return
     */
    SysUser selectById(@Param("user") SysUser user);

    /**
     * 7.根绝userId删除数据
     * @param userId 用户id
     * @return
     */
    int deleteUser(@Param("userId") Long userId);
}

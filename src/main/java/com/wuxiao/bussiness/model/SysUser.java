package com.wuxiao.bussiness.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sys_user")
public class SysUser {


    @Column(name = "user_id")
    private Integer userId;

    /**
     * 用户编号
     */
    @Column(name = "user_number")
    private String userNumber;

    /**
     * 用户名称
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 用户地址
     */
    @Column(name = "address")
    private String address;

    /**
     * 版本号
     */
    @Column(name = "object_version_number")
    private Integer objectVersionNumber;

    /**
     * 创建时间
     */
    @Column(name = "creation_date")
    private Date creationDate;

    /**
     * 创建人id
     */
    @Column(name = "created_by")
    private Integer createdBy;

    /**
     * 最后更新时间
     */
    @Column(name = "last_update_date")
    private Date lastUpdateDate;

    /**
     * 最后更新人id
     */
    @Column(name = "last_updated_by")
    private Integer lastUpdatedBy;

}

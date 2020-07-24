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
@Table(name = "order_header")
public class OrderHeader {


    /**
     * 订单头id
     */
    @Column(name = "order_header_id")
    private Integer orderHeaderId;

    /**
     * 订单编号
     */
    @Column(name = "order_number")
    private String orderNumber;

    /**
     * 客户id
     */
    @Column(name = "customer_user_id")
    private Integer customerUserId;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

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

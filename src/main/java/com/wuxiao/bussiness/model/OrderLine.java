package com.wuxiao.bussiness.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_line")
public class OrderLine {


    /**
     * 订单行id
     */
    @Column(name = "order_line_id")
    private Integer orderLineId;

    /**
     * 订单头id
     */
    @Column(name = "order_header_id")
    private Integer orderHeaderId;

    /**
     * 订单行号
     */
    @Column(name = "order_line_number")
    private Integer orderLineNumber;

    /**
     * 物料编码
     */
    @Column(name = "item_code")
    private String itemCode;

    /**
     * 物料名称
     */
    @Column(name = "item_name")
    private String itemName;

    /**
     * 单价
     */
    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    /**
     * 数量
     */
    @Column(name = "quantity")
    private BigDecimal quantity;

    /**
     * 行总价
     */
    @Column(name = "line_amount")
    private BigDecimal lineAmount;

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

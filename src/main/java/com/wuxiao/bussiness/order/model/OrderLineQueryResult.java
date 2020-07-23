package com.wuxiao.bussiness.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineQueryResult {
    private String orderNumber;
    private String userName;
    private String address;
    private String remark;
    private BigInteger createBy;
    private int orderLineNumber;
    private String itemCode;
    private String itemName;
    private BigDecimal unitPrice;
    private BigDecimal quantity;
    private BigDecimal lineAmount;

}

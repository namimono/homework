package com.wuxiao.bussiness.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineQueryCondition {
    private String orderNumber;
    private int orderLineNumber;
    private String itemCode;
    private String itemName;
    private BigInteger createdBy;
    private BigInteger customerUserId;
}

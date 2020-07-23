package com.wuxiao.bussiness.order.service;


import com.wuxiao.bussiness.order.model.OrderLineQueryCondition;
import com.wuxiao.bussiness.order.model.OrderLineQueryResult;

import java.util.List;

public interface OrderService {

    OrderHeader getOrderHeader();
//    4.
    List<OrderLineQueryResult> selectOrderLinesByCondition(OrderLineQueryCondition condition);
}

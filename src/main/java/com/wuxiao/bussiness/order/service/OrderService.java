package com.wuxiao.bussiness.order.service;


import com.wuxiao.bussiness.order.model.OrderLineQueryCondition;
import com.wuxiao.bussiness.order.model.OrderLineQueryResult;

import java.util.List;

public interface OrderService {

    /**
     * 4.
     * @param condition 查询条件
     * @return
     */
    List<OrderLineQueryResult> selectOrderLinesByCondition(OrderLineQueryCondition condition);
}

package com.wuxiao.bussiness.order.service.impl;

import com.wuxiao.bussiness.order.dao.OrderHeaderDao;
import com.wuxiao.bussiness.order.model.OrderLineQueryCondition;
import com.wuxiao.bussiness.order.model.OrderLineQueryResult;
import com.wuxiao.bussiness.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderHeaderDao orderHeaderDao;

    public List<OrderLineQueryResult> selectOrderLinesByCondition(OrderLineQueryCondition condition) {
        return orderHeaderDao.selectOrderLinesByCondition(condition);
    }
}

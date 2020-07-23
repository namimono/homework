package com.wuxiao.bussiness.order.service.impl;

import com.wuxiao.bussiness.model.OrderHeader;
import com.wuxiao.bussiness.order.dao.OrderHeaderDao;
import com.wuxiao.bussiness.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderHeaderDao orderHeaderDao;


    public OrderHeader getOrderHeader() {
        return orderHeaderDao.getOrderHeader();

    }
}

package com.wuxiao.bussiness.order.dao;

import com.wuxiao.bussiness.model.OrderHeader;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderHeaderDao {

    OrderHeader getOrderHeader();
}

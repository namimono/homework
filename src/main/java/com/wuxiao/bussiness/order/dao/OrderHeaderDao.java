package com.wuxiao.bussiness.order.dao;

import com.wuxiao.bussiness.order.model.OrderLineQueryCondition;
import com.wuxiao.bussiness.order.model.OrderLineQueryResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderHeaderDao {

    List<OrderLineQueryResult> selectOrderLinesByCondition(@Param("condition") OrderLineQueryCondition condition);
}

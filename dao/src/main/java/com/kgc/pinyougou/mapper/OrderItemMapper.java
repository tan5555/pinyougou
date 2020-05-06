package com.kgc.pinyougou.mapper;

import com.kgc.pinyougou.domain.OrderItem;
import com.kgc.pinyougou.domain.OrderItemExample;
import java.util.List;

public interface OrderItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    List<OrderItem> selectByExample(OrderItemExample example);

    OrderItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);
}
package com.zoro.mapper;

import java.util.List;

import com.zoro.domain.OrdersExt;

public interface OrdersMapper {

	public List<OrdersExt> findOrdersAndUser();
}

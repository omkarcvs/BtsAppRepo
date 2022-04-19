package com.app.bts.service;

import com.app.bts.entity.MyOrder;

public interface MyOrderService {
	
	void saveMyOrder(MyOrder order);
	MyOrder findByOrderId(String orderId);

}

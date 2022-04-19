package com.app.bts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.bts.dao.MyOrderRepository;
import com.app.bts.entity.MyOrder;

@Service
public class MyOrderServiceImp implements MyOrderService {

	@Autowired
	MyOrderRepository repo;
	
	@Override
	public void saveMyOrder(MyOrder order) {
		   repo.save(order);		
	}

	@Override
	public MyOrder findByOrderId(String orderId) {
		// TODO Auto-generated method stub
		return repo.findByOrderId(orderId);
	}

}

package com.order.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.entity.Order;
import com.order.entity.OrderStatus;
import com.order.exception.OrderInvalidException;
import com.order.repo.OrderRepo;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepo orderRepo;
	
	@Override
	public Order placeOrder(Order order) {
		// TODO Auto-generated method stub
		order.setOrderDate(LocalDate.now());
		order.setStatus(OrderStatus.PLACED);
		return this.orderRepo.save(order);
	}

	@Override
	public List<Order> getOrders() {
		// TODO Auto-generated method stub
		return this.orderRepo.findAll();
	}

	@Override
	public Order getOrderById(int orderId) throws OrderInvalidException {
		// TODO Auto-generated method stub
		Optional<Order> o=this.orderRepo.findById(orderId);
		if(o.isEmpty())
			throw new OrderInvalidException("id does not exists to delete");
		return o.get();
	}

	@Override
	public Order deleteOrder(Integer id) throws OrderInvalidException {
		// TODO Auto-generated method stub
		Optional<Order> o=this.orderRepo.findById(id);
		if(o.isEmpty())
			throw new OrderInvalidException("id does not exists to delete");
		this.orderRepo.deleteById(id);
		return o.get();
	}

	@Override
	public Order verifyOrder(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order pickUpOrder(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

}

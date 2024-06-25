package com.order.service;

import java.util.List;
import java.util.Optional;

import com.order.entity.Order;
import com.order.exception.OrderInvalidException;

public interface OrderService {
	
 public Order placeOrder(Order order);
	
	public List<Order> getOrders();
	
	public Order getOrderById(int orderId) throws OrderInvalidException;
	
	public Order deleteOrder(Integer id) throws OrderInvalidException;
	
	//public Order editOrder(Order order);
	
	public Order verifyOrder(Order order);
	
	public Order pickUpOrder(Order order);

}

package com.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.DTO.OrderDTO;
import com.order.entity.Order;
import com.order.exception.OrderInvalidException;
import com.order.service.OrderService;

@RestController
@RequestMapping
@CrossOrigin("*")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/addOrder")
	public Order placeOrder(@RequestBody OrderDTO orderDao) {
		Order order=new Order(orderDao.getId(),orderDao.getDoctorName(),orderDao.getDrugName(),orderDao.getDrugPrices(),orderDao.getQuantities(),orderDao.getOrderDate(),orderDao.getStatus());
		return this.orderService.placeOrder(order);
	}
	
	@GetMapping("/getOrders")
	public List<Order> getOrders(){
		return this.orderService.getOrders();
	}
	
	@GetMapping("/getOrderById/{orderId}")
	public Order getOrderById(@PathVariable int orderId) throws OrderInvalidException {
		return this.orderService.getOrderById(orderId);
	}
	
	@DeleteMapping("/deleteOrder/{id}")
	public Order deleteOrder(@PathVariable Integer id) throws OrderInvalidException {
		return this.orderService.deleteOrder(id);
	}

}

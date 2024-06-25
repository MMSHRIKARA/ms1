package com.order.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.order.entity.Order;
import com.order.entity.OrderStatus;
import com.order.exception.OrderInvalidException;
import com.order.repo.OrderRepo;

import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @InjectMocks
    private OrderServiceImpl orderService;

    @Mock
    private OrderRepo orderRepo;

    @Test
    public void testPlaceOrder() {
        Order order = new Order();
        order.setId(1);
        order.setOrderDate(LocalDate.now());
        order.setStatus(OrderStatus.PLACED);

        when(orderRepo.save(order)).thenReturn(order);

        Order placedOrder = orderService.placeOrder(order);

        assertNotNull(placedOrder);
        assertEquals(OrderStatus.PLACED, placedOrder.getStatus());
    }
    
    @Test
    public void testGetOrders() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1, "sheethal","dollo","13.45", 5, LocalDate.now(), OrderStatus.PLACED));

        when(orderRepo.findAll()).thenReturn(orders);

        List<Order> result = orderService.getOrders();
        assertEquals(1, result.size());
    }
    
    @Test
    public void testDeleteOrder() throws OrderInvalidException {
        Order order = new Order(1, "sheethal","dollo","13.45", 5, LocalDate.now(), OrderStatus.PLACED);

        when(orderRepo.findById(1)).thenReturn(Optional.of(order));
        Order deletedOrder = orderService.deleteOrder(1);

        assertNotNull(deletedOrder);
        assertEquals(1, deletedOrder.getId());
    }

    @Test
    public void testGetOrderById() throws OrderInvalidException {
        int orderId = 1;
        Order order = new Order(1, "sheethal","dollo","13.45", 5, LocalDate.now(), OrderStatus.PLACED);

        when(orderRepo.findById(orderId)).thenReturn(Optional.of(order));

        Order result = orderService.getOrderById(orderId);
        assertNotNull(result);
     
}
}

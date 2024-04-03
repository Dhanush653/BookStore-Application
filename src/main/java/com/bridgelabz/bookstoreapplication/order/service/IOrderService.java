package com.bridgelabz.bookstoreapplication.order.service;

import com.bridgelabz.bookstoreapplication.order.dto.OrderDTO;
import com.bridgelabz.bookstoreapplication.order.entity.OrderEntity;

import java.util.List;

public interface IOrderService {
    OrderEntity placeOrder(OrderDTO orderDTO);
    boolean cancelOrder(Long orderId);
    List<OrderEntity> getAllOrders();
    List<OrderEntity> getAllOrdersForUser(Long userId);
}

package com.bridgelabz.bookstoreapplication.order.controller;


import com.bridgelabz.bookstoreapplication.order.dto.OrderDTO;
import com.bridgelabz.bookstoreapplication.order.entity.OrderEntity;
import com.bridgelabz.bookstoreapplication.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IOrderService orderservice;

    @PostMapping("/orderplace")
    public ResponseEntity<OrderEntity> placeOrder(@RequestBody OrderDTO orderDTO) {
            OrderEntity order = orderservice.placeOrder(orderDTO);
            return ResponseEntity.ok(order);
    }
    @PutMapping("/{orderid}/cancel")
    public ResponseEntity<?> cancelOrder(@PathVariable Long orderid) {

            boolean result = orderservice.cancelOrder(orderid);
            if (result) {
                return ResponseEntity.ok().body("Order cancelled successfully.");
            }
            else {
                return ResponseEntity.badRequest().body("Order not found.");
            }
    }

    @GetMapping
    public ResponseEntity<List<OrderEntity>> getAllOrders() {
        List<OrderEntity> orders = orderservice.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<OrderEntity>> getAllOrdersForUser(@PathVariable Long userId) {
        try {
            List<OrderEntity> orders = orderservice.getAllOrdersForUser(userId);
            return ResponseEntity.ok(orders);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }


}

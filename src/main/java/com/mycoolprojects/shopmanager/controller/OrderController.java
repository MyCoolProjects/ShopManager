package com.mycoolprojects.shopmanager.controller;

import com.mycoolprojects.shopmanager.entity.Order;
import com.mycoolprojects.shopmanager.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("${api-path}")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/orders")
    public Map<String, List<Order>> getAllOrders(Pageable pageable) {
        return Collections.singletonMap("orders", orderRepository.findAll());
    }

    @PostMapping("/orders")
    public Order addOrder(@RequestBody Order order) {
        return null;
    }

}

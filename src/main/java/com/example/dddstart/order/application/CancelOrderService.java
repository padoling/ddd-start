package com.example.dddstart.order.application;

import com.example.dddstart.order.NoOrderException;
import com.example.dddstart.order.domain.Order;
import com.example.dddstart.order.domain.OrderNo;
import com.example.dddstart.order.domain.OrderRepository;
import jakarta.transaction.Transactional;

public class CancelOrderService {
    private OrderRepository orderRepository;

    @Transactional
    public void cancel(OrderNo number) {
        Order order = orderRepository.findById(number)
                .orElseThrow(() -> new NoOrderException());
        order.cancel();
    }
}

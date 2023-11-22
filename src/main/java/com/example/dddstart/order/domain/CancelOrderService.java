package com.example.dddstart.order.domain;

import com.example.dddstart.order.NoOrderException;
import jakarta.transaction.Transactional;

public class CancelOrderService {
    private OrderRepository orderRepository;

    @Transactional
    public void cancel(OrderNo number) {
        Order order = orderRepository.findByNumber(number);
        if (order == null) {
            throw new NoOrderException();
        }
        order.cancel();
    }
}

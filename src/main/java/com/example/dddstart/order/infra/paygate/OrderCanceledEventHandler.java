package com.example.dddstart.order.infra.paygate;

import com.example.dddstart.order.application.RefundService;
import com.example.dddstart.order.domain.OrderCanceledEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

// OrderCanceledEvent를 처리하는 핸들러
@Service
public class OrderCanceledEventHandler {
    private RefundService refundService;

    public OrderCanceledEventHandler(RefundService refundService) {
        this.refundService = refundService;
    }

    @EventListener(OrderCanceledEvent.class)
    public void handle(OrderCanceledEvent event) {
        refundService.refund(event.getOrderNumber());
    }
}

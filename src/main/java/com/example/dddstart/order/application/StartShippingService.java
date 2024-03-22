package com.example.dddstart.order.application;

import com.example.dddstart.common.VersionConflictException;
import com.example.dddstart.order.NoOrderException;
import com.example.dddstart.order.domain.Order;
import com.example.dddstart.order.domain.OrderNo;
import com.example.dddstart.order.domain.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StartShippingService {

    private final OrderRepository orderRepository;

    @PreAuthorize("hasRole('ADMIN')")
    @Transactional
    public void startShipping(StartShippingRequest req) {
        Order order = orderRepository.findById(new OrderNo(req.getOrderNumber()))
                .orElseThrow(NoOrderException::new);
        if (!order.matchVersion(req.getVersion())) {
            throw new VersionConflictException();
        }
        order.startShipping();
    }
}

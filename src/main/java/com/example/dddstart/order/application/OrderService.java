package com.example.dddstart.order.application;

import com.example.dddstart.order.domain.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final DiscountCalculationService discountCalculationService;
    private final OrderRepository orderRepository;

    @Transactional
    public OrderNo placeOrder(OrderRequest orderRequest) {
        OrderNo orderNo = orderRepository.nextId();
        Order order = createOrder(orderNo, orderRequest);
        orderRepository.save(order);
        // 응용 서비스 실행 후 표현 영역에서 필요한 값만 리턴
        return orderNo;
    }

    private Order createOrder(OrderNo orderNo, OrderRequest orderRequest) {
//        Member member = findMember(orderRequest.getOrdererId());
        Order order = new Order(new Orderer(orderRequest.getOrdererId()), null, null, null);
        // 응용 서비스에서 애그리거트에 도메인서비스 주입
        order.calculateAmounts(discountCalculationService);
        return order;
    }
}

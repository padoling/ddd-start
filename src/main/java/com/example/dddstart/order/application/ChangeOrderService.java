package com.example.dddstart.order.application;

import com.example.dddstart.member.domain.Member;
import com.example.dddstart.member.domain.MemberRepository;
import com.example.dddstart.order.OrderNotFoundException;
import com.example.dddstart.order.domain.Order;
import com.example.dddstart.order.domain.OrderNo;
import com.example.dddstart.order.domain.OrderRepository;
import com.example.dddstart.order.domain.ShippingInfo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChangeOrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;

    // 두 개 이상의 애그리거트를 변경해야 한다면 응용 서비스에서 각 애그리거트의 상태를 변경한다.
    @Transactional
    public void changeShippingInfo(OrderNo id, ShippingInfo newShippingInfo, boolean useNewShippingAddrAsMemberAddr) {
        Order order = orderRepository.findByNumber(id);
        if (order == null) {
            throw new OrderNotFoundException();
        }
        order.changeShippingInfo(newShippingInfo);
        if (useNewShippingAddrAsMemberAddr) {
            // id를 이용하여 다른 애그리거트 참조
            Member member = memberRepository.findById(order.getOrderer().getMemberId());
            member.changeAddress(newShippingInfo.getAddress());
        }
    }
}

package com.example.dddstart.order.query.dto;

import com.example.dddstart.member.domain.MemberId;
import com.example.dddstart.order.domain.OrderNo;
import com.example.dddstart.order.domain.OrderState;
import lombok.Getter;

@Getter
public class OrderView {
    // memberId, orderNo와 같은 값들을 기본 타입으로 변환하여 조회 전용 모델로 사용
    private final String number;
    private final OrderState state;
    private final String memberName;
    private final String memberId;
    private final String productName;

    public OrderView(OrderNo number, OrderState state, String memberName, MemberId memberId, String productName) {
        this.number = number.getNumber();
        this.state = state;
        this.memberName = memberName;
        this.memberId = memberId.getId();
        this.productName = productName;
    }
}

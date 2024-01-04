package com.example.dddstart.order.query.dto;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

import java.time.LocalDateTime;

// JPA 정적 메타 모델 클래스
// 대상 모델의 각 프로퍼티와 동일한 이름을 갖는 정적 필드를 정의한다
@StaticMetamodel(OrderSummary.class)
public class OrderSummary_ {
    public static volatile SingularAttribute<OrderSummary, String> number;
    public static volatile SingularAttribute<OrderSummary, Long> version;
    public static volatile SingularAttribute<OrderSummary, String> ordererId;
    public static volatile SingularAttribute<OrderSummary, String> ordererName;
    public static volatile SingularAttribute<OrderSummary, LocalDateTime> orderDate;
}

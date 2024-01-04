package com.example.dddstart.order.query.dao;

import com.example.dddstart.order.query.dto.OrderSummary;
import com.example.dddstart.order.query.dto.OrderSummary_;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

// 별도 클래스에 스펙 기능 모으기
public class OrderSummarySpecs {
    public static Specification<OrderSummary> ordererId(String ordererId)    {
        // Spec은 함수형 인터페이스이므로 람다식으로 객체 생성 가능
        return (Root<OrderSummary> root,
                CriteriaQuery<?> query,
                CriteriaBuilder criteriaBuilder) ->
                // 다음과 같이 문자열로 프로퍼티를 지정할 수도 있음
                // criteriaBuilder.equal(root.get("ordererId"), ordererId);
                criteriaBuilder.equal(root.get(OrderSummary_.ordererId), ordererId);
    }

    public static Specification<OrderSummary> orderDateBetween(LocalDateTime from, LocalDateTime to) {
        return (Root<OrderSummary> root,
                CriteriaQuery<?> query,
                CriteriaBuilder criteriaBuilder) ->
                criteriaBuilder.between(root.get(OrderSummary_.orderDate), from, to);
    }
}

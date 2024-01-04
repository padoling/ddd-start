package com.example.dddstart.order.query.dao;

import com.example.dddstart.order.query.dto.OrderSummary;
import com.example.dddstart.order.query.dto.OrderSummary_;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class OrdererIdSpec implements Specification<OrderSummary> {

    private String ordererId;

    public OrdererIdSpec(String ordererId) {
        this.ordererId = ordererId;
    }

    // 다음과 같이 문자열로 프로퍼티를 지정할 수도 있음
    // criteriaBuilder.equal(root.get("ordererId"), ordererId);
    @Override
    public Predicate toPredicate(Root<OrderSummary> root,
                                 CriteriaQuery<?> query,
                                 CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.equal(root.get(OrderSummary_.ordererId), ordererId);
    }
}

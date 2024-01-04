package com.example.dddstart.order.query.dao;

import com.example.dddstart.order.query.dto.OrderSummary;
import com.example.dddstart.order.query.dto.OrderView;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface OrderSummaryDao extends Repository<OrderSummary, String> {
    // 스펙을 충족하는 엔티티 조회
    List<OrderSummary> findAll(Specification<OrderSummary> spec);
    List<OrderSummary> findAll(Specification<OrderSummary> spec, Sort sort);

    // 정렬 순서 지정
    List<OrderSummary> findByOrdererIdOrderByNumberDesc(String ordererId);
    List<OrderSummary> findByOrdererId(String ordererId, Sort sort);

    // new 키워드로 인스턴스 동적으로 생성 가능
    // 객체 기준으로 쿼리를 작성하고 지연/즉시 로딩 고민 없이 데이터를 조회할 수 있음
    @Query("""
            select new com.example.dddstart.order.query.dto.OrderView(
                o.number, o.state, m.name, m.id, p.name
            )
            from Order o join o.orderLines ol, Member m, Product p
            where o.orderer.memberId.id = :ordererId
            and o.orderer.memberId.id = m.id
            and index(ol) = 0
            and ol.productId.id = p.productId
            order by o.number.number desc
            """)
    List<OrderView> findOrderView(String ordererId);
}

package com.example.dddstart.order.query.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Synchronize;

import java.time.LocalDateTime;


@Entity
// 아래는 Hibernate 전용 어노테이션들.

// 매핑한 테이블이 없으므로 수정이 이루어지면 에러가 발생한다. @Immutable을 사용하면 변경되어도 DB에 반영하지 않고 무시한다.
@Immutable
// 조회 쿼리를 값으로 갖는다. 쿼리 실행 결과를 매핑할 테이블처럼 사용한다.
// 일반 @Entity와 같기 때문에 EntityManager.#find(), JPQL, Criteria를 사용해서 조회할 수 있다.
// 값으로 지정한 쿼리를 from 절의 서브 쿼리로 사용한다.
@Subselect(
        """
        select o.order_number as number,
        o.version, o.orderer_id, o.orderer_name,
        o.total_amounts, o.receiver_name, o.state, o.order_date,
        p.product_id, p.name as product_name
        from purchase_order o inner join order_line ol
            on o.order_number = ol.order_number
            cross join product p 
        where
        ol.line_idx = 0
        and ol.product_id = p.product_id"""
)
// 엔티티와 관련된 테이블 목록을 명시하고 엔티티 로딩 전 테이블에 번경이 발생하면 flush를 먼저 한다.
@Synchronize({"purchase_order", "order_line", "product"})
public class OrderSummary {
    @Id
    private String number;
    private Long version;
    @Column(name = "orderer_id")
    private String ordererId;
    @Column(name = "orderer_name")
    private String ordererName;
    private LocalDateTime orderDate;

    protected OrderSummary() {
    }
}

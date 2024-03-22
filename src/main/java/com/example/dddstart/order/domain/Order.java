package com.example.dddstart.order.domain;

import com.example.dddstart.common.jpa.MoneyConverter;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

//@EqualsAndHashCode(of = {"orderNumber"})
// Aggregate Root Entity에 해당하는 객체.
@Entity
@Table(name = "purchase_order")
@Access(AccessType.FIELD)
public class Order {
    @Getter
    @EmbeddedId
    private OrderNo number;

    // optimistic lock - 비선점 잠금을 위한 version 필드 명시
    @Version
    private long version;

    @Getter
    @Embedded
    private Orderer orderer;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private OrderState state;

    @Embedded
    private ShippingInfo shippingInfo;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "order_line",
                joinColumns = @JoinColumn(name = "order_number"))
    @OrderColumn(name = "line_idx")     // List 타입 자체가 인덱스를 갖고 있음
    private List<OrderLine> orderLines;

    @Column(name = "total_amounts")
    @Convert(converter = MoneyConverter.class)
    private Money totalAmounts;

    private List<Coupon> coupons;

    protected Order() {
    }

    public Order(Orderer orderer, List<OrderLine> orderLines, ShippingInfo shippingInfo, OrderState state) {
        setOrderer(orderer);
        setOrderLines(orderLines);
        setShippingInfo(shippingInfo);
        this.state = state;
    }

    private void setOrderer(Orderer orderer) {
        if (orderer == null) throw new IllegalArgumentException("no orderer");
        this.orderer = orderer;
    }

    private void setOrderLines(List<OrderLine> orderLines) {
        verifyAtLeastOneOrMoreOrderLines(orderLines);
        this.orderLines = orderLines;
        calculateTotalAmounts();
    }

    private void setShippingInfo(ShippingInfo shippingInfo) {
        if (shippingInfo == null) {
            throw new IllegalArgumentException("no ShippingInfo");
        }
        // value 타입의 데이터를 변경할 때는 새로운 객체로 교체한다.
        this.shippingInfo = shippingInfo;
    }

    private void verifyAtLeastOneOrMoreOrderLines(List<OrderLine> orderLines) {
        if (orderLines == null || orderLines.isEmpty()) {
            throw new IllegalArgumentException("no OrderLine");
        }
    }

    public void calculateAmounts(DiscountCalculationService disCalSvc) {
        Money discountAmounts = disCalSvc.calculateDiscountAmounts(this.orderLines, this.coupons, null);
        // something discount logic...
    }

    private void calculateTotalAmounts() {
        int sum = orderLines.stream()
                .mapToInt(ol -> ol.getAmounts().getValue())
                .sum();
        this.totalAmounts = new Money(sum);
    }

    public void changeShipped() {}

    public void changeShippingInfo(ShippingInfo newShippingInfo) {
        verifyNotYetShipped();
        setShippingInfo(newShippingInfo);
    }

    public void cancel() {
        verifyNotYetShipped();
        this.state = OrderState.CANCELED;
    }

    public void completePayment() {}

    private void verifyNotYetShipped() {
        if (state != OrderState.PAYMENT_WAITING && state != OrderState.PREPARING) {
            throw new IllegalStateException("already shipped");
        }
    }

    public boolean matchVersion(long version) {
        return version == this.version;
    }

    public void startShipping() {
        // TODO
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (obj.getClass() != Order.class) return false;
        Order other = (Order) obj;
        if (this.number == null) return false;
        return this.number.equals(other.number);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((number == null) ? 0 : number.hashCode());
        return result;
    }
}

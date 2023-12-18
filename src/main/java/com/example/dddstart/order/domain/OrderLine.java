package com.example.dddstart.order.domain;

import com.example.dddstart.catalog.domain.product.ProductId;
import com.example.dddstart.common.jpa.MoneyConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Getter;

@Embeddable
public class OrderLine {
    @Embedded
    private ProductId productId;

    @Column(name = "price")
    @Convert(converter = MoneyConverter.class)
    private Money price;

    @Column(name = "quantity")
    private int quantity;
    @Getter
    @Column(name = "amounts")
    @Convert(converter = MoneyConverter.class)
    private Money amounts;

    protected OrderLine() {
    }

    public OrderLine(ProductId productId, Money price, int quantity) {
        this.productId = productId;
        // Money가 불변객체가 아닐 경우를 대비하여 데이터를 복사한 새로운 객체 생성
        this.price = new Money(price.getValue());
        this.quantity = quantity;
        this.amounts = calculateAmounts();
    }

    private Money calculateAmounts() {
        return price.multiply(quantity);
    }
}

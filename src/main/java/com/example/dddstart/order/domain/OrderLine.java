package com.example.dddstart.order.domain;

import com.example.dddstart.catalog.domain.product.Product;
import lombok.Getter;

public class OrderLine {
    private Product product;
    private Money price;
    private int quantity;
    @Getter
    private Money amounts;

    public OrderLine(Product product, Money price, int quantity) {
        this.product = product;
        // Money가 불변객체가 아닐 경우를 대비하여 데이터를 복사한 새로운 객체 생성
        this.price = new Money(price.getValue());
        this.quantity = quantity;
        this.amounts = calculateAmounts();
    }

    private Money calculateAmounts() {
        return price.multiply(quantity);
    }
}

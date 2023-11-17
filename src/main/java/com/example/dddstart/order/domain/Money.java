package com.example.dddstart.order.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

// Value 객체. 불변하게 구현하는 것이 중요하다.
@EqualsAndHashCode
public class Money {
    @Getter
    private int value;

    public Money(int value) {
        this.value = value;
    }

    public Money add(Money money) {
        // Value 객체의 경우 변경보다 새로 생성하는 방식 선호. 불변성 유지를 위함.
        return new Money(this.value + money.value);
    }

    public Money multiply(int multiplier) {
        return new Money(this.value * multiplier);
    }
}

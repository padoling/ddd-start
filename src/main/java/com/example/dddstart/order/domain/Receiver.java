package com.example.dddstart.order.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
// Value 객체는 equals에서 모든 속성값이 같은지 비교한다.
@EqualsAndHashCode
public class Receiver {
    private String name;
    private String phoneNumber;

    public Receiver(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}

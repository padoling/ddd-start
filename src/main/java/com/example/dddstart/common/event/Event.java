package com.example.dddstart.common.event;

import lombok.Getter;

// 모든 이벤트가 공통으로 갖는 프로퍼티 구현
@Getter
public abstract class Event {
    private long timestamp;

    public Event() {
        this.timestamp = System.currentTimeMillis();
    }
}

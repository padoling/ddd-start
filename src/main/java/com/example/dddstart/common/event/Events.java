package com.example.dddstart.common.event;

import org.springframework.context.ApplicationEventPublisher;

// 스프링 컨테이너는 ApplicationEventPublisher도 됨
public class Events {
    private static ApplicationEventPublisher publisher;

    static void setPublisher(ApplicationEventPublisher publisher) {
        Events.publisher = publisher;
    }

    public static void raise(Object event) {
        if (publisher != null) {
            publisher.publishEvent(event);
        }
    }
}

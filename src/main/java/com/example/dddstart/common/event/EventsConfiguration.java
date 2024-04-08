package com.example.dddstart.common.event;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventsConfiguration {
    @Autowired
    private ApplicationContext applicationContext;

    // InitializingBean : 스프링 빈객체를 초기화할 때 사용하는 인터페이스
    @Bean
    public InitializingBean eventsInitializer() {
        // ApplicationContext는 ApplicationEventPublisher를 상속하고 있음
        return () -> Events.setPublisher(applicationContext);
    }
}

package com.example.dddstart.order.infra.paygate;

import com.example.dddstart.order.application.RefundService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ExternalRefundService implements RefundService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void refund(String orderNumber) {
        logger.info("refund order[{}]", orderNumber);
    }
}

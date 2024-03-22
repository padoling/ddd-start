package com.example.dddstart.admin.ui;

import com.example.dddstart.common.VersionConflictException;
import com.example.dddstart.order.application.StartShippingRequest;
import com.example.dddstart.order.application.StartShippingService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AdminOrderController {

    private final StartShippingService startShippingService;

    @PostMapping("/startShipping")
    public String startShipping(StartShippingRequest req) {
        try {
            startShippingService.startShipping(req);
            return "shippingStarted";
        } catch(OptimisticLockingFailureException | VersionConflictException ex) {
            // 트랜잭션 충돌
            // OptimisticLockingFailureException은 누군가 거의 동시에 애그리거트를 수정했음을 의미
            // VersionConflictException은 이미 누군가가 애그리거트를 수정했음을 의미
            return "startShippingConflict";
        }
    }
}

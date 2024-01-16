package com.example.dddstart.order.domain;

import java.util.List;

// 할인 금액 계산 로직을 위한 도메인 서비스
// 애그리거트나 응용 서비스에서 사용
public class DiscountCalculationService {
    public Money calculateDiscountAmounts(List<OrderLine> orderLines,
                                          List<Coupon> coupons,
                                          MemberGrade grade) {
        Money couponDiscount = coupons.stream()
                .map(this::calculateDiscount)
                .reduce(new Money(0), Money::add);

        Money membershipDiscount = calculateDiscount(grade);

        return couponDiscount.add(membershipDiscount);
    }

    private Money calculateDiscount(Coupon coupon) {
        // TODO
        return null;
    }

    private Money calculateDiscount(MemberGrade grade) {
        // TODO
        return null;
    }
}

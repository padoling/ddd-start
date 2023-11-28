package com.example.dddstart.order.domain;

import com.example.dddstart.member.domain.MemberId;
import lombok.Getter;

@Getter
public class Orderer {
    private MemberId memberId;
    private String name;
    private String email;
}

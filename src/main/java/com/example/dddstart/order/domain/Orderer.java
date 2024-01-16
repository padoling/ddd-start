package com.example.dddstart.order.domain;

import com.example.dddstart.member.domain.MemberId;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Embeddable
public class Orderer {
    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "id", column = @Column(name = "orderer_id"))
    )
    private MemberId memberId;

    @Column(name = "orderer_name")
    private String name;
    @Column(name = "orderer_email")
    private String email;

    protected Orderer() {
    }

    public Orderer(MemberId memberId) {
        this.memberId = memberId;
    }
}

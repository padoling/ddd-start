package com.example.dddstart.member.query;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "member")
public class MemberData {

    @Id
    @Column(name = "member_id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "blocked")
    private boolean blocked;

    public MemberData() {
    }

    public MemberData(String id, String name, boolean blocked) {
        this.id = id;
        this.name = name;
        this.blocked = blocked;
    }
}

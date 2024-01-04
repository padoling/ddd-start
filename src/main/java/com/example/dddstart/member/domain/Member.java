package com.example.dddstart.member.domain;

import com.example.dddstart.common.jpa.EmailSetConverter;
import com.example.dddstart.common.model.EmailSet;
import com.example.dddstart.member.PasswordNotMatchException;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "member")
public class Member {
    @EmbeddedId
    private MemberId id;

    private String name;

    @Column(name = "emails")
    @Convert(converter = EmailSetConverter.class)
    private EmailSet emailSet;

    @Embedded
    private Password password;

    public Member() {
    }

    public Member(MemberId id, String name) {
        this.id = id;
        this.name = name;
    }

    public void changePassword(String currentPassword, String newPassword) {
        if (!password.match(currentPassword)) {
            throw new PasswordNotMatchException();
        }
    }
}

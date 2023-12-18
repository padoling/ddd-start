package com.example.dddstart.member.domain;

import com.example.dddstart.common.jpa.EmailSetConverter;
import com.example.dddstart.common.model.EmailSet;
import com.example.dddstart.member.PasswordNotMatchException;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import lombok.Getter;

@Getter
public class Member {
    private MemberId id;

    @Column(name = "emails")
    @Convert(converter = EmailSetConverter.class)
    private EmailSet emailSet;

    private Password password;

    public void changePassword(String currentPassword, String newPassword) {
        if (!password.match(currentPassword)) {
            throw new PasswordNotMatchException();
        }
    }
}

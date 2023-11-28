package com.example.dddstart.member.domain;

import com.example.dddstart.member.PasswordNotMatchException;
import lombok.Getter;

@Getter
public class Member {
    private MemberId memberId;
    private Password password;

    public void changePassword(String currentPassword, String newPassword) {
        if (!password.match(currentPassword)) {
            throw new PasswordNotMatchException();
        }
    }
}

package com.example.dddstart.member.application;

import lombok.Data;

@Data
public class ChangePasswordRequest {
    private String memberId;
    private String currentPassword;
    private String newPassword;
}

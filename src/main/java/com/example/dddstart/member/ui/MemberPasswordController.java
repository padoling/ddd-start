package com.example.dddstart.member.ui;

import com.example.dddstart.member.application.ChangePasswordRequest;
import com.example.dddstart.member.application.ChangePasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member/changePassword")
public class MemberPasswordController {

    private final ChangePasswordService changePasswordService;

    // Spring MVC 프레임워크에서 HTTP 요청 파라미터로부터 자바 객체를 생성하는 기능 지원
    @PostMapping()
    public String submit(ChangePasswordRequest changePasswordRequest) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        changePasswordRequest.setMemberId(auth.getName());
        try {
            changePasswordService.changePassword(changePasswordRequest);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "";
    }
}

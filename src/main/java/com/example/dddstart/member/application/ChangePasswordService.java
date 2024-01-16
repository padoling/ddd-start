package com.example.dddstart.member.application;

import com.example.dddstart.member.domain.Member;
import com.example.dddstart.member.domain.MemberId;
import com.example.dddstart.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ChangePasswordService {
    private final MemberRepository memberRepository;

    public void changePassword(ChangePasswordRequest req) {
        Member member = findExistingMember(req.getMemberId());
        member.changePassword(req.getCurrentPassword(), req.getNewPassword());
    }

    private Member findExistingMember(String memberId) {
        return memberRepository.findById(new MemberId(memberId));
    }
}

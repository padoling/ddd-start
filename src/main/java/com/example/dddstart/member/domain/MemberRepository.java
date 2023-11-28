package com.example.dddstart.member.domain;

public interface MemberRepository {
    Member findById(MemberId memberId);
}

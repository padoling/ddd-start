package com.example.dddstart.member.query;

import org.springframework.data.jpa.domain.Specification;

public class MemberDataSpecs {
    public static Specification<MemberData> nonBlocked() {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.<Boolean>get("blocked"), false);
    }

    public static Specification<MemberData> nameLike(String keyword) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.<String>get("name"), keyword + "%");
    }
}

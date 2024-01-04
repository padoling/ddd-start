package com.example.dddstart.member.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface MemberDataDao extends Repository<MemberData, String> {
    // 페이징 처리
    // COUNT 쿼리도 함께 실행해서 조건에 해당하는 데이터 개수를 구한다.
    // findBy 형식의 메소드는 return 타입이 List이면 COUNT 쿼리를 실행하지 않는다.
    Page<MemberData> findByNameLike(String name, Pageable pageable);

    // 스펙을 사용하는 메소드는 리턴 타입이 Page가 아니어도 COUNT 쿼리를 실행한다.
    List<MemberData> findAll(Specification<MemberData> spec, Pageable pageable);

    // 처음부터 N개의 데이터만 조회
    List<MemberData> findFirst3ByNameLikeOrderByName(String name);
}

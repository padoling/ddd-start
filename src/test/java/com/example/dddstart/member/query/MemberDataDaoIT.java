package com.example.dddstart.member.query;

import com.example.dddstart.common.jpa.SpecBuilder;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

@SpringBootTest
public class MemberDataDaoIT {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private MemberDataDao memberDataDao;

    @Test
    void specBuilder() {
        SearchRequest searchRequest = new SearchRequest();
        Specification<MemberData> spec = SpecBuilder.builder(MemberData.class)
                // 조건이 참인 경우 Spec을 리턴하는 함수를 받아 추가한다.
                .ifTrue(
                        searchRequest.isOnlyNotBlocked(),
                        () -> MemberDataSpecs.nonBlocked())
                // 유효한 String인 경우 Spec을 리턴하는 함수를 받아 추가한다. nameLike은 문자열을 비교하는 스펙을 리턴한다.
                .ifHasText(searchRequest.getName(),
                        name -> MemberDataSpecs.nameLike(searchRequest.getName()))
                .toSpec();
        List<MemberData> result = memberDataDao.findAll(spec, PageRequest.of(0, 5));
        logger.info("result: {}", result.size());
    }
}

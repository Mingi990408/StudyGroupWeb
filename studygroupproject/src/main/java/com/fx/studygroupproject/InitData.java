package com.fx.studygroupproject;

import com.fx.studygroupproject.user.Member;
import com.fx.studygroupproject.user.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
@RequiredArgsConstructor
public class InitData {
    private final MemberRepository memberRepository;

    @PostConstruct
    void setMemberTestData() {
        Member member = new Member("asd@naver.com", "Asd1234!", "TestData");
        memberRepository.addMember(member);
        log.info("save Member : " + member.toString() );
    }
}

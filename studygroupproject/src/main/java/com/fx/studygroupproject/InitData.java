package com.fx.studygroupproject;

import com.fx.studygroupproject.recruitment.ContactType;
import com.fx.studygroupproject.recruitment.Recruitment;
import com.fx.studygroupproject.recruitment.repository.UseRepository;
import com.fx.studygroupproject.user.Member;
import com.fx.studygroupproject.user.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class InitData {
    private final MemberRepository memberRepository;
    private final UseRepository useRepository;

    @PostConstruct
    void setMemberTestData() {
        Member member = new Member("asd@naver.com", "Asd1234!", "TestData");
        memberRepository.addMember(member);
        log.info("save Member : " + member.toString());
        List<String> Tag = new ArrayList<>();
        Tag.add("test");
        Tag.add("test");
        Recruitment recruitment1 = new Recruitment("테스트", "내용", member.getNickname(), Tag, ContactType.Offline);
        Recruitment recruitment2 = new Recruitment("테스트", "내용",member.getNickname(), Tag, ContactType.Offline);
        useRepository.addRecruitment(member, recruitment1);
        useRepository.addRecruitment(member, recruitment2);
    }
}

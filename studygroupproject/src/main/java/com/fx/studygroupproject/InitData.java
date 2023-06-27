package com.fx.studygroupproject;

import com.fx.studygroupproject.notice.ContactType;
import com.fx.studygroupproject.notice.Notice;
import com.fx.studygroupproject.notice.repository.UseRepository;
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
        Notice notice1 = new Notice("테스트", "내용", Tag, ContactType.Offline);
        Notice notice2 = new Notice("테스트", "내용", Tag, ContactType.Offline);
        useRepository.addNotice(member, notice1);
        useRepository.addNotice(member, notice2);
    }
}

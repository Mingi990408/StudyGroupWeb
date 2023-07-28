package com.fx.studygroupproject;

import com.fx.studygroupproject.recruitment.ContactType;
import com.fx.studygroupproject.recruitment.Recruitment;
import com.fx.studygroupproject.recruitment.repository.RecruitmentRepository;
import com.fx.studygroupproject.studygroup.RoomType;
import com.fx.studygroupproject.studygroup.StudyGroup;
import com.fx.studygroupproject.studygroup.repository.StudyGroupRepository;
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
    private final RecruitmentRepository recruitmentRepository;

    private final StudyGroupRepository studyGroupRepository;

    @PostConstruct
    void setMemberTestData() {
        Member member = new Member("asd@naver.com", "Asd1234!", "TestData");
        memberRepository.addMember(member);
        log.info("save Member : " + member.toString());
        List<String> Tag = new ArrayList<>();
        Tag.add("test");
        Tag.add("test");
        Recruitment recruitment1 = new Recruitment("테스트", "내용", member.getNickname(), Tag, ContactType.Offline, "우리집" );
        Recruitment recruitment2 = new Recruitment("테스트1", "내용1",member.getNickname(), Tag, ContactType.Offline, "우리집1");
        recruitmentRepository.addRecruitment(member, recruitment1);
        recruitmentRepository.addRecruitment(member, recruitment2);

        StudyGroup studyGroup1 = new StudyGroup("테스트 방 제목", "방 소개", member.getNickname(), RoomType.Open);

        studyGroupRepository.addStudyGroup(member, studyGroup1);
    }
}

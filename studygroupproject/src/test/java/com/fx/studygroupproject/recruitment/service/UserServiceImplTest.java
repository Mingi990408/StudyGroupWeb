package com.fx.studygroupproject.recruitment.service;

import com.fx.studygroupproject.recruitment.ContactType;
import com.fx.studygroupproject.recruitment.Recruitment;
import com.fx.studygroupproject.recruitment.repository.UseRepository;
import com.fx.studygroupproject.user.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UseRepository useRepository;
    @Test
    void createNotice() {
        List<String> Tag = new ArrayList<>();
        Tag.add("test");
        Tag.add("test");
        Member member = new Member("asd@naver.com", "Asd1234!", "TestData");
        Recruitment recruitment1 = new Recruitment("테스트", "내용",member.getNickname(), Tag, ContactType.Offline);
        Recruitment recruitment2 = new Recruitment("테스트", "내용",member.getNickname(), Tag, ContactType.Offline);
        useRepository.addNotice(member, recruitment1);
        useRepository.addNotice(member, recruitment2);
    }

    @Test
    void findMyNotice() {
        List<String> Tag = new ArrayList<>();
        Tag.add("test");
        Tag.add("test");
        Member member = new Member("asd@naver.com", "Asd1234!", "TestData");
        System.out.println("member = " + member);

        Recruitment recruitment1 = new Recruitment("테스트1", "내용",member.getNickname(), Tag, ContactType.Offline);
        Recruitment recruitment2 = new Recruitment("테스트2", "내용",member.getNickname(), Tag, ContactType.Offline);
        useRepository.addNotice(member, recruitment1);
        useRepository.addNotice(member, recruitment2);
        Optional<List<Recruitment>> byMember = useRepository.findByMember(member);
        System.out.println("byMember = " + byMember);

        List<String> Tag2 = new ArrayList<>();
        Tag.add("test2");
        Tag.add("test2");
        Member member2 = new Member("qwe@naver.com", "Qwe1234!", "TestData2");
        System.out.println("member2 = " + member2);
        Recruitment recruitment1_1 = new Recruitment("테스트1_1", "내용",member2.getNickname(), Tag2, ContactType.All);
        Recruitment recruitment1_2 = new Recruitment("테스트2_2", "내용",member2.getNickname(), Tag2, ContactType.Online);
        useRepository.addNotice(member2, recruitment1_1);
        useRepository.addNotice(member2, recruitment1_2);
        Optional<List<Recruitment>> notices = useRepository.findByMember(member2);
        System.out.println("notices = " + notices);
        List<Recruitment> all = (List<Recruitment>) useRepository.All();
        System.out.println("all = " + all);
    }
}
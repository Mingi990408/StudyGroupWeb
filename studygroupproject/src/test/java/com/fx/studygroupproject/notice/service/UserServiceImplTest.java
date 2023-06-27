package com.fx.studygroupproject.notice.service;

import com.fx.studygroupproject.notice.ContactType;
import com.fx.studygroupproject.notice.Notice;
import com.fx.studygroupproject.notice.repository.UseRepository;
import com.fx.studygroupproject.user.Member;
import com.fx.studygroupproject.user.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

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
        Notice notice1 = new Notice("테스트", "내용", Tag, ContactType.Offline);
        Notice notice2 = new Notice("테스트", "내용", Tag, ContactType.Offline);
        useRepository.addNotice(member, notice1);
        useRepository.addNotice(member, notice2);
    }

    @Test
    void findMyNotice() {
        List<String> Tag = new ArrayList<>();
        Tag.add("test");
        Tag.add("test");
        Member member = new Member("asd@naver.com", "Asd1234!", "TestData");
        System.out.println("member = " + member);

        Notice notice1 = new Notice("테스트1", "내용", Tag, ContactType.Offline);
        Notice notice2 = new Notice("테스트2", "내용", Tag, ContactType.Offline);
        useRepository.addNotice(member, notice1);
        useRepository.addNotice(member, notice2);
        Optional<List<Notice>> byMember = useRepository.findByMember(member);
        System.out.println("byMember = " + byMember);

        List<String> Tag2 = new ArrayList<>();
        Tag.add("test2");
        Tag.add("test2");
        Member member2 = new Member("qwe@naver.com", "Qwe1234!", "TestData2");
        System.out.println("member2 = " + member2);
        Notice notice1_1 = new Notice("테스트1_1", "내용", Tag2, ContactType.All);
        Notice notice1_2 = new Notice("테스트2_2", "내용", Tag2, ContactType.Online);
        useRepository.addNotice(member2, notice1_1);
        useRepository.addNotice(member2, notice1_2);
        Optional<List<Notice>> notices = useRepository.findByMember(member2);
        System.out.println("notices = " + notices);
        Collection<List<Notice>> all = useRepository.All();
        System.out.println("all = " + all);
    }
}
package com.fx.studygroupproject.user.service;

import com.fx.studygroupproject.InitData;
import com.fx.studygroupproject.user.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class MemberServiceImplTest {

    @Autowired
    private MemberService memberService;

    @Test
    @DisplayName("회원가입")
    void signup() {
        Member member1 = new Member("qwe1234@naver.com", "1234", "nickname");
        memberService.signup(member1);
        memberService.signup(member1);
    }

    @Test
    @DisplayName("로그인")
    void login() {
        Member member1 = new Member("qwe1234@naver.com", "1234", "nickname");
        memberService.signup(member1);
        Member login = memberService.login("qwe1234@naver.com", "1234");
    }
}
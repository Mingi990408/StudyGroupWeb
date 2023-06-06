package com.fx.studygroupproject.user.service;

import com.fx.studygroupproject.user.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceImplTest {

    private MemberService memberService;
    @Test
    @DisplayName("회원가입")
    void signup() {
        Member member1 = new Member("qwe1234@naver.com", "1234", "nickname");
        Member member2 = memberService.signup(member1);
        assertThat(member1).isEqualTo(member2);
    }

    @Test
    @DisplayName("로그인")
    void login() {
        Member member1 = new Member("qwe1234@naver.com", "1234", "nickname");
        memberService.signup(member1);
        boolean login = memberService.login("qwe1234@naver.com", "1234");
        assertThat(login).isTrue();
    }
}
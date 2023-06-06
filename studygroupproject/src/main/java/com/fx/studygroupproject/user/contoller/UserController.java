package com.fx.studygroupproject.user.contoller;

import com.fx.studygroupproject.user.Member;
import com.fx.studygroupproject.user.service.MemberService;
import com.fx.studygroupproject.user.service.MemberServiceImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final MemberService memberService;

    @PostMapping("/login-callback")
    public boolean loginCallback(String Email, String Password) {
        return memberService.login(Email, Password);
    }

    @PostMapping("signup-callback")
    public String signupCallback(Member member) {
        memberService.signup(member);
        return "home";
    }
}

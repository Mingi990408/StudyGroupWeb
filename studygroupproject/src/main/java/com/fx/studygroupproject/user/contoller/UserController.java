package com.fx.studygroupproject.user.contoller;

import com.fx.studygroupproject.user.Member;
import com.fx.studygroupproject.user.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@Slf4j
@RequiredArgsConstructor
public class UserController {
    private final MemberService memberService;

    @PostMapping("/login-callback")
    public boolean loginCallback(String Email, String Password) {
        return memberService.login(Email, Password);
    }

    @PostMapping("signup-callback")
    public String signupCallback(@ModelAttribute("member") @Valid Member member, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup";
        }
        memberService.signup(member);
        return "homepage";
    }
    @GetMapping("/email/duplicate-check")
    public void  emailDuplicateCheck(@RequestParam String email, HttpServletResponse response){
        if (memberService.emailDuplicateCheck(email)) {
            response.setStatus(HttpServletResponse.SC_OK);
        }
        else
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }
    @GetMapping("/nickname/duplicate-check")
    public void  nicknameDuplicateCheck(@RequestParam String nickname, HttpServletResponse response){
        if (memberService.nicknameDuplicateCheck(nickname)) {
            response.setStatus(HttpServletResponse.SC_OK);
        }
        else
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }
}

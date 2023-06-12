package com.fx.studygroupproject.user.contoller;

import com.fx.studygroupproject.user.Member;
import com.fx.studygroupproject.user.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String signupCallback(@ModelAttribute("member") @Valid Member member, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "signup";
        }
        if(memberService.emailDuplicateCheck(member)){
            bindingResult.rejectValue("email", "error.user", "중복된 이메일입니다.");
            return "signup";
        }
        if(memberService.nicknameDuplicateCheck(member)){
            bindingResult.rejectValue("nickname", "error.user", "중복된 닉네임입니다.");
            return "signup";
        }
        memberService.signup(member);
        return "homepage";
    }
    @PostMapping("/email/duplicate-check")
    public void  emailDuplicateCheck(HttpServletResponse response){
        response.setStatus(400);
    }
    @PostMapping("/nickname/duplicate-check")
    public void  nicknameDuplicateCheck(HttpServletResponse response){
        response.setStatus(400);
    }
}

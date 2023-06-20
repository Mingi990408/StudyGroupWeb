package com.fx.studygroupproject.user.contoller;

import com.fx.studygroupproject.user.Member;
import com.fx.studygroupproject.user.service.EmailService;
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
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@Slf4j
@RequiredArgsConstructor
public class SignupController {
    private final MemberService memberService;
    private final EmailService emailService;


    @PostMapping("signup-callback")
    public String signupCallback(@ModelAttribute("member") @Valid Member member, HttpSession session, BindingResult bindingResult, Model model) throws Exception {
        if (bindingResult.hasErrors()) {
            return "signup";
        }
        session.setAttribute("member", member);
        model.addAttribute("member", member);
        emailService.sendAuthMessage(member);
        return "checkEmail";
    }

    @GetMapping("auth-check")
    public void authCheck(@RequestParam String authCode, HttpSession session, HttpServletResponse response) {
        String authCode1 = emailService.getAuthCode();

        Member member = (Member) session.getAttribute("member");
        if (authCode1.equals(authCode)) {
            memberService.signup(member);
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
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

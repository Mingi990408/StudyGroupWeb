package com.fx.studygroupproject.user.contoller;

import com.fx.studygroupproject.user.Member;
import com.fx.studygroupproject.user.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequiredArgsConstructor
public class LoginController {
    private final MemberService memberService;

    @PostMapping("/login-callback")
    public String loginCallback(String Email, String Password, Model model, HttpServletResponse response) {
        Member loginUser = memberService.login(Email, Password);
        if (loginUser != null) {
            response.setStatus(HttpServletResponse.SC_OK);
            model.addAttribute("member", loginUser);
            return "homepage";
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return "redirect:/login?error";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}

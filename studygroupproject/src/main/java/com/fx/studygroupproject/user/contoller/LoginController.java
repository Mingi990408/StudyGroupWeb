package com.fx.studygroupproject.user.contoller;

import com.fx.studygroupproject.user.Member;
import com.fx.studygroupproject.user.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequiredArgsConstructor
public class LoginController {
    private final MemberService memberService;
    @PostMapping("/login-callback")
    public String loginCallback(String Email, String Password, HttpServletResponse response) {
        if (memberService.login(Email, Password)) {
            response.setStatus(HttpServletResponse.SC_OK);
            return "homepage";
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return "redirect:/login?error";
        }
    }
}

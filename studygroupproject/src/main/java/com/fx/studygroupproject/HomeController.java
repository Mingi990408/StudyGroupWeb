package com.fx.studygroupproject;

import com.fx.studygroupproject.user.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @GetMapping("/homepage")
    public String homepage(HttpSession session, Model model) {
        Member member = (Member) session.getAttribute("member");
        model.addAttribute("member", member);
        return "homepage";
    }
}

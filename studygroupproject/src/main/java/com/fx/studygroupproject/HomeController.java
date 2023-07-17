package com.fx.studygroupproject;

import com.fx.studygroupproject.recruitment.Recruitment;
import com.fx.studygroupproject.recruitment.service.UseService;
import com.fx.studygroupproject.user.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class HomeController {
    private final UseService useService;
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
        List<Recruitment> recruitments = useService.findAll();
        model.addAttribute("member", member);
        model.addAttribute("recruitments", recruitments);
        return "homepage";
    }
}

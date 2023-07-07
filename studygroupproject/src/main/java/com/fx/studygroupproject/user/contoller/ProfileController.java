package com.fx.studygroupproject.user.contoller;

import com.fx.studygroupproject.user.Member;
import com.fx.studygroupproject.user.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ProfileController {
    private final MemberService memberService;
    @GetMapping(value = "/profile")
    public String profile(HttpSession session, Model model){
        Member member = (Member) session.getAttribute("member");
        model.addAttribute("member", member);
        return "profile";
    }

    @GetMapping("/change/pw")
    public void passwordChange(String newPassword, HttpServletResponse response, HttpSession session) {
        Member member = (Member) session.getAttribute("member");
        if(memberService.change(member, newPassword))
            response.setStatus(HttpServletResponse.SC_OK);
        else
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }
}

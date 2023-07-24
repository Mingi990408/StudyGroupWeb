package com.fx.studygroupproject;

import com.fx.studygroupproject.recruitment.Recruitment;
import com.fx.studygroupproject.recruitment.service.RecruitmentService;
import com.fx.studygroupproject.studygroup.StudyGroup;
import com.fx.studygroupproject.studygroup.service.StudyGroupService;
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
    private final RecruitmentService recruitmentService;
    private final StudyGroupService studyGroupService;
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
        List<Recruitment> recruitments = recruitmentService.findAll();
        List<StudyGroup> studyGroups = studyGroupService.findAll();

        model.addAttribute("member", member);
        model.addAttribute("recruitments", recruitments);
        model.addAttribute("studyGroups", studyGroups);
        return "homepage";
    }
}

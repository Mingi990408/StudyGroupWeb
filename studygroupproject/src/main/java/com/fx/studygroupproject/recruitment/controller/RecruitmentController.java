package com.fx.studygroupproject.recruitment.controller;

import com.fx.studygroupproject.recruitment.Recruitment;
import com.fx.studygroupproject.recruitment.service.RecruitmentService;
import com.fx.studygroupproject.user.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class RecruitmentController {
    private final RecruitmentService recruitmentService;
    @PostMapping("recruitment")
    public void CreateRecruitment(HttpServletResponse response, HttpSession session, Recruitment recruitment) {
        Member member = (Member) session.getAttribute("member");
        recruitment.setWriter(member.getNickname());
        response.setStatus(HttpServletResponse.SC_OK);
        recruitmentService.CreateRecruitment(member, recruitment);
    }

}

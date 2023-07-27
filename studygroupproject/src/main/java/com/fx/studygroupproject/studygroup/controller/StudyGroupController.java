package com.fx.studygroupproject.studygroup.controller;

import com.fx.studygroupproject.studygroup.StudyGroup;
import com.fx.studygroupproject.studygroup.service.StudyGroupService;
import com.fx.studygroupproject.user.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class StudyGroupController {
    private final StudyGroupService studyGroupService;

    @PostMapping("study-group")
    public void CreateStudyGroup(HttpServletResponse response, HttpSession session, StudyGroup studyGroup, Model model) {
        Member member = (Member) session.getAttribute("member");
        System.out.println("studyGroup = " + studyGroup.toString());
        studyGroup.setSgWriter(member.getNickname());
        studyGroupService.CreateNotice(member, studyGroup);
        model.addAttribute("studyGroups", studyGroupService.findAll());
        response.setStatus(HttpServletResponse.SC_OK);
    }
}

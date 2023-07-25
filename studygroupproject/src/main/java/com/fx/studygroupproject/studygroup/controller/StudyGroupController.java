package com.fx.studygroupproject.studygroup.controller;

import com.fx.studygroupproject.studygroup.StudyGroup;
import com.fx.studygroupproject.studygroup.service.StudyGroupService;
import com.fx.studygroupproject.user.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class StudyGroupController {
    private final StudyGroupService studyGroupService;

    @PostMapping("new-studygroup")
    public void CreateStudyGroup(HttpSession session, StudyGroup studyGroup) {
        Member member = (Member) session.getAttribute("member");
        studyGroup.setSgWriter(member.getNickname());
        studyGroupService.CreateNotice(member, studyGroup);
    }
}

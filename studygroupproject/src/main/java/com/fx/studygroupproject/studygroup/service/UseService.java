package com.fx.studygroupproject.studygroup.service;

import com.fx.studygroupproject.studygroup.StudyGroup;
import com.fx.studygroupproject.user.Member;

import java.util.List;

public interface UseService {
    void CreateNotice(Member member, StudyGroup recruitment);
    List<StudyGroup> findMyNotice(Member member);

    List<StudyGroup> findAll();

}

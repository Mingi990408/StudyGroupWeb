package com.fx.studygroupproject.recruitment.service;

import com.fx.studygroupproject.recruitment.Recruitment;
import com.fx.studygroupproject.user.Member;

import java.util.List;

public interface UseService {
    void CreateRecruitment(Member member, Recruitment recruitment);
    List<Recruitment> findMyRecruitment(Member member);

    List<Recruitment> findAll();

}

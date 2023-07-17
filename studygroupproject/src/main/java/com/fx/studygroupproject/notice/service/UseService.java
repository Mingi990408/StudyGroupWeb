package com.fx.studygroupproject.notice.service;

import com.fx.studygroupproject.notice.Recruitment;
import com.fx.studygroupproject.user.Member;

import java.util.List;

public interface UseService {
    void CreateNotice(Member member, Recruitment recruitment);
    List<Recruitment> findMyNotice(Member member);

    List<Recruitment> findAll();

}

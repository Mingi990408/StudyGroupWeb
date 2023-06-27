package com.fx.studygroupproject.notice.service;

import com.fx.studygroupproject.notice.Notice;
import com.fx.studygroupproject.user.Member;

import java.util.List;

public interface UseService {
    void CreateNotice(Member member, Notice notice);
    List<Notice> findMyNotice(Member member);

}

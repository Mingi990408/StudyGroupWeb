package com.fx.studygroupproject.notice.repository;

import com.fx.studygroupproject.notice.Notice;
import com.fx.studygroupproject.user.Member;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UseRepository {
    Optional<Notice> addNotice(Member member,Notice notice);
    Optional<List<Notice>> findByMember(Member member);

    Collection<List<Notice>> All();
}

package com.fx.studygroupproject.notice.repository;

import com.fx.studygroupproject.notice.Recruitment;
import com.fx.studygroupproject.user.Member;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UseRepository {
    Optional<Recruitment> addNotice(Member member, Recruitment recruitment);
    Optional<List<Recruitment>> findByMember(Member member);

    Collection<Recruitment> All();
}

package com.fx.studygroupproject.notice.repository;

import com.fx.studygroupproject.user.Member;

import java.util.Optional;

public interface UseRepository {
    Optional<Member> addGroup(Member member);
    Optional<Member> addNotice(Member member);
    Optional<Member> findById(Member member);
}

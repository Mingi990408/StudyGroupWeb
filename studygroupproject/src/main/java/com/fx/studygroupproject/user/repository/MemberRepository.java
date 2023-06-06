package com.fx.studygroupproject.user.repository;

import com.fx.studygroupproject.user.Member;

import java.util.Optional;

public interface MemberRepository {
    Optional<Member> addMember(Member member);
    boolean findMember(Member member);
}

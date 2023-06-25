package com.fx.studygroupproject.user.repository;

import com.fx.studygroupproject.user.Member;

import java.util.Optional;

public interface MemberRepository {
    Optional<Member> addMember(Member member);
    Optional<Member> findMember(Member member);

    Optional<Member>  findByEmail(String email);

    Optional<Member>  findByNickname(String nickname);

    Optional<Member> changePassword(Member member, String newPassword);
}

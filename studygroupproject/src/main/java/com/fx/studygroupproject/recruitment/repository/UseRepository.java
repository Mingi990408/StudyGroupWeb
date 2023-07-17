package com.fx.studygroupproject.recruitment.repository;

import com.fx.studygroupproject.recruitment.Recruitment;
import com.fx.studygroupproject.user.Member;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UseRepository {
    Optional<Recruitment> addRecruitment(Member member, Recruitment recruitment);
    Optional<List<Recruitment>> findByMember(Member member);

    Collection<Recruitment> All();
}

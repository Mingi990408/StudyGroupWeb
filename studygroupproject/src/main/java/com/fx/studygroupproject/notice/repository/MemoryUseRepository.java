package com.fx.studygroupproject.notice.repository;

import com.fx.studygroupproject.user.Member;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MemoryUseRepository implements UseRepository{
    private static final Map<Long, Member> store = new HashMap<>();
    @Override
    public Optional<Member> addGroup(Member member) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> addNotice(Member member) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findById(Member member) {
        return Optional.empty();
    }
}

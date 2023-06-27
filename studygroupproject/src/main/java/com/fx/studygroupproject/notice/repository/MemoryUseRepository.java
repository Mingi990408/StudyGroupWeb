package com.fx.studygroupproject.notice.repository;

import com.fx.studygroupproject.notice.Notice;
import com.fx.studygroupproject.user.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryUseRepository implements UseRepository{
    private static final Map<Member, List<Notice>> store = new HashMap<>();

    @Override
    public Optional<Notice> addNotice(Member member, Notice notice) {
        List<Notice> notices = store.get(member);
        if (notices == null) {
            notices = new ArrayList<>();
        }
        notices.add(notice);
        store.put(member, notices);
        return Optional.of(notice);
    }

    @Override
    public Optional<List<Notice>> findByMember(Member member) {
        List<Notice> notices = store.get(member);
        return Optional.ofNullable(notices);
    }

    public Collection<List<Notice>> All() {
        return store.values();
    }
}

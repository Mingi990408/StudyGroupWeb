package com.fx.studygroupproject.recruitment.repository;

import com.fx.studygroupproject.recruitment.Recruitment;
import com.fx.studygroupproject.user.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryUseRepository implements UseRepository{
    private static final Map<Long, Recruitment> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Optional<Recruitment> addRecruitment(Member member, Recruitment recruitment) {
        recruitment.setId(++sequence);
        member.addNoticeId(recruitment.getId());
        store.put(recruitment.getId(), recruitment);

        return Optional.ofNullable(store.get(recruitment.getId()));
    }

    @Override
    public Optional<List<Recruitment>> findByMember(Member member) {
        List<Recruitment> recruitments = new ArrayList<>();
        for (Long NoticeId : member.getNoticeList()) {
            recruitments.add(store.get(NoticeId));
        }
        return Optional.of(recruitments);
    }

    public List<Recruitment> All() {
        return new ArrayList<Recruitment>(store.values());
    }
}

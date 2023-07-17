package com.fx.studygroupproject.studygroup.repository;

import com.fx.studygroupproject.studygroup.StudyGroup;
import com.fx.studygroupproject.user.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryUseRepository implements UseRepository {
    private static final Map<Long, StudyGroup> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Optional<StudyGroup> addNotice(Member member, StudyGroup recruitment) {
        recruitment.setId(++sequence);
        member.addNoticeId(recruitment.getId());
        store.put(recruitment.getId(), recruitment);

        return Optional.ofNullable(store.get(recruitment.getId()));
    }

    @Override
    public Optional<List<StudyGroup>> findByMember(Member member) {
        List<StudyGroup> recruitments = new ArrayList<>();
        for (Long NoticeId : member.getNoticeList()) {
            recruitments.add(store.get(NoticeId));
        }
        return Optional.of(recruitments);
    }

    public List<StudyGroup> All() {
        return new ArrayList<StudyGroup>(store.values());
    }
}

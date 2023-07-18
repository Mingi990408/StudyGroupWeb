package com.fx.studygroupproject.studygroup.repository;

import com.fx.studygroupproject.studygroup.StudyGroup;
import com.fx.studygroupproject.user.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryStudyGroupRepository implements StudyGroupRepository {
    private static final Map<Long, StudyGroup> store = new HashMap<>();
    private static long sequence = 0L;
    @Override
    public Optional<StudyGroup> addStudyGroup(Member member, StudyGroup studyGroup) {
        studyGroup.setId(++sequence);
        member.addStudyGroupId(studyGroup.getId());
        store.put(studyGroup.getId(), studyGroup);

        return Optional.ofNullable(store.get(studyGroup.getId()));
    }

    @Override
    public Optional<List<StudyGroup>> findByMember(Member member) {
        List<StudyGroup> recruitments = new ArrayList<>();
        for (Long NoticeId : member.getStudyGroupList()) {
            recruitments.add(store.get(NoticeId));
        }
        return Optional.of(recruitments);
    }

    public List<StudyGroup> All() {
        return new ArrayList<StudyGroup>(store.values());
    }
}

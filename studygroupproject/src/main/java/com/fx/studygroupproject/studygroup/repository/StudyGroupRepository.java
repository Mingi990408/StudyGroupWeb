package com.fx.studygroupproject.studygroup.repository;

import com.fx.studygroupproject.studygroup.StudyGroup;
import com.fx.studygroupproject.user.Member;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface StudyGroupRepository {
    Optional<StudyGroup> addStudyGroup(Member member, StudyGroup studyGroup);
    Optional<List<StudyGroup>> findByMember(Member member);

    Collection<StudyGroup> All();
}

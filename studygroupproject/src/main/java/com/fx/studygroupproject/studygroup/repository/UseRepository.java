package com.fx.studygroupproject.studygroup.repository;

import com.fx.studygroupproject.studygroup.StudyGroup;
import com.fx.studygroupproject.user.Member;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UseRepository {
    Optional<StudyGroup> addNotice(Member member, StudyGroup recruitment);
    Optional<List<StudyGroup>> findByMember(Member member);

    Collection<StudyGroup> All();
}

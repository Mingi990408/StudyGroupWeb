package com.fx.studygroupproject.studygroup.service;

import com.fx.studygroupproject.studygroup.StudyGroup;
import com.fx.studygroupproject.studygroup.repository.StudyGroupRepository;
import com.fx.studygroupproject.user.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudyGroupServiceImpl implements StudyGroupService {
    private final StudyGroupRepository studyGroupRepository;

    @Override
    public void CreateNotice(Member member, StudyGroup recruitment) {
        studyGroupRepository.addStudyGroup(member, recruitment);
    }

    @Override
    public List<StudyGroup> findMyNotice(Member member) {
        if (studyGroupRepository.findByMember(member).isPresent()) {
            return studyGroupRepository.findByMember(member).get();
        }
        return null;
    }

    @Override
    public List<StudyGroup> findAll() {
        return (List<StudyGroup>) studyGroupRepository.All();
    }
}

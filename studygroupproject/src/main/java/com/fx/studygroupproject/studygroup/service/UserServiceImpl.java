package com.fx.studygroupproject.studygroup.service;

import com.fx.studygroupproject.studygroup.StudyGroup;
import com.fx.studygroupproject.studygroup.repository.UseRepository;
import com.fx.studygroupproject.user.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UseService {
    private final UseRepository useRepository;

    @Override
    public void CreateNotice(Member member, StudyGroup recruitment) {
        useRepository.addNotice(member, recruitment);
    }

    @Override
    public List<StudyGroup> findMyNotice(Member member) {
        if (useRepository.findByMember(member).isPresent()) {
            return useRepository.findByMember(member).get();
        }
        return null;
    }

    @Override
    public List<StudyGroup> findAll() {
        return (List<StudyGroup>) useRepository.All();
    }
}

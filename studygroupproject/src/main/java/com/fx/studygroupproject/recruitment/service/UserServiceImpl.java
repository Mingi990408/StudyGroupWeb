package com.fx.studygroupproject.recruitment.service;

import com.fx.studygroupproject.recruitment.Recruitment;
import com.fx.studygroupproject.recruitment.repository.UseRepository;
import com.fx.studygroupproject.user.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UseService {
    private final UseRepository useRepository;

    @Override
    public void CreateNotice(Member member, Recruitment recruitment) {
        useRepository.addNotice(member, recruitment);
    }

    @Override
    public List<Recruitment> findMyNotice(Member member) {
        if (useRepository.findByMember(member).isPresent()) {
            return useRepository.findByMember(member).get();
        }
        return null;
    }

    @Override
    public List<Recruitment> findAll() {
        return (List<Recruitment>) useRepository.All();
    }
}

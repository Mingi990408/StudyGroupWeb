package com.fx.studygroupproject.recruitment.service;

import com.fx.studygroupproject.recruitment.Recruitment;
import com.fx.studygroupproject.recruitment.repository.RecruitmentRepository;
import com.fx.studygroupproject.user.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecruitmentServiceImpl implements RecruitmentService {
    private final RecruitmentRepository recruitmentRepository;

    @Override
    public void CreateRecruitment(Member member, Recruitment recruitment) {
        recruitmentRepository.addRecruitment(member, recruitment);
    }

    @Override
    public List<Recruitment> findMyRecruitment(Member member) {
        if (recruitmentRepository.findByMember(member).isPresent()) {
            return recruitmentRepository.findByMember(member).get();
        }
        return null;
    }

    @Override
    public List<Recruitment> findAll() {
        return (List<Recruitment>) recruitmentRepository.All();
    }
}

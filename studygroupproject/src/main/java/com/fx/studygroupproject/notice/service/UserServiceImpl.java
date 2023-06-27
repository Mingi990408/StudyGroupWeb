package com.fx.studygroupproject.notice.service;

import com.fx.studygroupproject.notice.Notice;
import com.fx.studygroupproject.notice.repository.UseRepository;
import com.fx.studygroupproject.user.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UseService {
    private final UseRepository useRepository;

    @Override
    public void CreateNotice(Member member, Notice notice) {
        useRepository.addNotice(member, notice);
    }

    @Override
    public List<Notice> findMyNotice(Member member) {
        if (useRepository.findByMember(member).isPresent()) {
            return useRepository.findByMember(member).get();
        }
        return null;
    }
}

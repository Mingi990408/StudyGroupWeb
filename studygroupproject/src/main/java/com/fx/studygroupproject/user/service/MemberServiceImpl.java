package com.fx.studygroupproject.user.service;

import com.fx.studygroupproject.user.Member;
import com.fx.studygroupproject.user.repository.MemberRepository;
import com.fx.studygroupproject.user.repository.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;
    @Override
    public Member signup(Member member) {
        return memberRepository.addMember(member).get();
    }

    @Override
    public boolean login(String Email, String Password) {
        Member member = new Member(Email, Password);
        return memberRepository.findMember(member);
    }
}

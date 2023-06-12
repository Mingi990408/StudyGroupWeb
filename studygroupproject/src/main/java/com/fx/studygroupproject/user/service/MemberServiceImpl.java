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
    public void signup(Member member) {
        memberRepository.addMember(member);
    }

    @Override
    public boolean login(String Email, String Password) {
        Member member = new Member(Email, Password);
        return memberRepository.findMember(member).isPresent();
    }

    @Override
    public boolean emailDuplicateCheck(Member member) {
        return memberRepository.findByEmail(member.getEmail()).isEmpty();
    }

    @Override
    public boolean nicknameDuplicateCheck(Member member) {
        return memberRepository.findByNickname(member.getNickname()).isEmpty();
    }
}

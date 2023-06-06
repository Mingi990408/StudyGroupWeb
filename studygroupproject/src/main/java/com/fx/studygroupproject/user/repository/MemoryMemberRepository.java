package com.fx.studygroupproject.user.repository;

import com.fx.studygroupproject.user.Member;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class MemoryMemberRepository implements MemberRepository {
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Optional<Member> addMember(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return Optional.ofNullable(member);
    }

    @Override
    public boolean findMember(Member member) {
        for (Member out:store.values()){
            if (out.getEmail().equals(member.getEmail()) && out.getPassword().equals(member.getPassword())){
                return true;
            }
        }
        return false;
    }
}

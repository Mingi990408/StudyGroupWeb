package com.fx.studygroupproject.user.repository;

import com.fx.studygroupproject.user.Member;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class MemoryMemberRepository implements MemberRepository {
    private static final Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Optional<Member> addMember(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return Optional.of(member);
    }

    @Override
    public Optional<Member> findMember(Member member) {
        for (Member out:store.values()){
            if (out.getEmail().equals(member.getEmail()) && out.getPassword().equals(member.getPassword())){
                return Optional.of(out);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Member>  findByEmail(String email) {
        for (Member out : store.values()) {
            if (out.getEmail().equals(email)) {
                return Optional.of(out);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Member>  findByNickname(String nickname) {
        for (Member out : store.values()) {
            if (out.getNickname().equals(nickname)) {
                return Optional.of(out);
            }
        }
        return Optional.empty();
    }
}

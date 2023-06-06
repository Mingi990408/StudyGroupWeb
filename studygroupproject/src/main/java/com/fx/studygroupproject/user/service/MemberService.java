package com.fx.studygroupproject.user.service;

import com.fx.studygroupproject.user.Member;

public interface MemberService {
    Member signup(Member member);
    boolean login(String Email, String Password);

}

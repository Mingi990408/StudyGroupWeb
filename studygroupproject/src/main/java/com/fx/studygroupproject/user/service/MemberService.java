package com.fx.studygroupproject.user.service;

import com.fx.studygroupproject.user.Member;

public interface MemberService {
    void signup(Member member);
    boolean login(String Email, String Password);

    boolean emailDuplicateCheck(Member member);
    boolean nicknameDuplicateCheck(Member member);
}

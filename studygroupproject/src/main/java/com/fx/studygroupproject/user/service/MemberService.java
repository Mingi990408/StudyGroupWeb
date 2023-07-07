package com.fx.studygroupproject.user.service;

import com.fx.studygroupproject.user.Member;

public interface MemberService {
    void signup(Member member);
    Member login(String Email, String Password);

    boolean emailDuplicateCheck(String email);
    boolean nicknameDuplicateCheck(String nickname);

    boolean change(Member member, String newPassword);
}

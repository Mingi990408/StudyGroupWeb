package com.fx.studygroupproject.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Member {

    private Long id;
    private String Email;
    private String Password;
    private String Nickname;

    public Member(String email, String password) {
        Email = email;
        Password = password;
    }

    public Member(String email, String password, String nickname) {
        Email = email;
        Password = password;
        Nickname = nickname;
    }
}

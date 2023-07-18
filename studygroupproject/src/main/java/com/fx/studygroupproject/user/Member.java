package com.fx.studygroupproject.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Member {

    private Long id;
    @NotBlank(message = "이메일은 필수 입력값입니다.")
    @Email
    private String Email;
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,16}$",
            message = "비밀번호는 8~16자리수여야 합니다. 영문 대소문자, 숫자, 특수문자를 1개 이상 포함해야 합니다.")
    private String Password;
    @NotBlank(message = "닉네임은 필수 입력값입니다.")
    @Pattern(regexp = "^[가-힣a-zA-Z0-9]{2,10}$" ,
            message = "닉네임은 특수문자를 포함하지 않은 2~10자리여야 합니다.")
    private String Nickname;

    private List<Long> RecruitmentList = new ArrayList<>();

    private List<Long> StudyGroupList = new ArrayList<>();

    public Member(String email, String password) {
        Email = email;
        Password = password;
    }

    public Member(String email, String password, String nickname) {
        Email = email;
        Password = password;
        Nickname = nickname;
    }
    public void addRecruitmentId(Long recruitmentId){
        this.RecruitmentList.add(recruitmentId);
    }

    public void addStudyGroupId(Long studyGroupId) {
        this.StudyGroupList.add(studyGroupId);
    }
}

package com.fx.studygroupproject.notice;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Recruitment {
    private Long Id;
    private String Title;
    private String Contents;

    private String Writer;
    private List<String> Tag;
    private ContactType Type;

    public Recruitment(String title, String contents, String writer, List<String> tag, ContactType type) {
        Title = title;
        Contents = contents;
        Writer = writer;
        Tag = tag;
        Type = type;
    }
}

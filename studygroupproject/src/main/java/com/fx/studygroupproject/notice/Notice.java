package com.fx.studygroupproject.notice;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Notice {
    private String Title;
    private String Contents;
    private List<String> Tag;
    private ContactType Type;

    public Notice(String title, String contents, List<String> tag, ContactType type) {
        Title = title;
        Contents = contents;
        Tag = tag;
        Type = type;
    }
}

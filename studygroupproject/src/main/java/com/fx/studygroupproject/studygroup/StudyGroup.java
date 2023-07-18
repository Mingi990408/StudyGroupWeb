package com.fx.studygroupproject.studygroup;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class StudyGroup {
    private Long Id;
    private String Title;
    private String Contents;
    private String Writer;
    private RoomType Type;

    public StudyGroup(String title, String contents, String writer, RoomType type) {
        Title = title;
        Contents = contents;
        Writer = writer;
        Type = type;
    }
}

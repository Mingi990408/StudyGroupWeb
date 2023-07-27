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
    private String sgTitle;
    private String sgIntroduce;
    private String sgContents;
    private String sgWriter;
    private String Password;
    private RoomType Type;

    public StudyGroup(String title, String contents, String writer, RoomType type) {
        sgTitle = title;
        sgContents = contents;
        sgWriter = writer;
        Type = type;
    }
}

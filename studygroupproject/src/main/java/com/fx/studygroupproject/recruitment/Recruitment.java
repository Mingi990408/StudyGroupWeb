package com.fx.studygroupproject.recruitment;

import lombok.*;

import java.io.File;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Recruitment {
    private Long Id;
    private String rTitle;
    private String rContents;
    private File rFile;
    private String Writer;
    private List<String> rTag;
    private ContactType Type;
    private String Location;

    public Recruitment(String title, String contents, String writer, List<String> tag, ContactType type, String location) {
        rTitle = title;
        rContents = contents;
        Writer = writer;
        rTag = tag;
        Type = type;
        Location = location;
    }
}

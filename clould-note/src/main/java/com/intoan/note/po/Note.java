package com.intoan.note.po;

import lombok.Data;

import java.util.Date;

@Data
public class Note {

    private Integer noteId;
    private String title;
    private String content;
    private Integer typeId;
    private Date publicTime;
    private float lon;
    private float lat;

    private String typeName;
}

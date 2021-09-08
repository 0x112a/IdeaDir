package com.intoan.note.po;

import lombok.Data;

@Data
public class User {
    /**
     * User Class
     */
    private Integer userId;
    private String uname;
    private String upwd;
    private String nick;
    private String head;
    private String mood;

}

package com.samsung.itschool.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class UserAccountDto {

    private Long id;

    private String name;

    private String login;

    private String password;

    private String secretWord;

    private Date birthDate;

    private String passportInfo;
}

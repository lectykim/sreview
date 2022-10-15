package com.sreviewonly.board.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@Getter
public class CounselDTO {


    private long id;

    private String title;

    private String content;

    private String email;


}

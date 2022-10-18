package com.sreviewonly.board.dto;

import com.sreviewonly.board.entites.Counsel;
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

    public CounselDTO(Counsel counsel){
        this.id=counsel.getId();
        this.title = counsel.getTitle();
        this.email = counsel.getEmail();
    }


}

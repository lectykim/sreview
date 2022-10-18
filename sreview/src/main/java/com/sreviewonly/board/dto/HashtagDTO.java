package com.sreviewonly.board.dto;

import com.sreviewonly.board.entites.Hashtag;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HashtagDTO {

    private long id;

    private String tagId;

    private long tagCnt;

    public HashtagDTO(Hashtag hashtag){
        this.id=hashtag.getId();
        this.tagId= hashtag.getTagId();
        this.tagCnt =hashtag.getTagCnt();
    }


}

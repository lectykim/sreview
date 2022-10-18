package com.sreviewonly.board.dto;

import com.sreviewonly.board.entites.Heart;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeartDTO {

    private long id;

    private long reviewId;


    private long userId;

    public HeartDTO(Heart heart){
        this.id=heart.getId();
        this.reviewId = heart.getReviewId();
        this.userId = heart.getUserId();
    }

}

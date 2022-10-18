package com.sreviewonly.board.dto;

import com.sreviewonly.board.entites.Product;
import com.sreviewonly.board.entites.Review;
import com.sreviewonly.board.entites.enums.PREFERSEX;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
public class ReviewDTO {

    private long id;

    private long hits;


    private String content;


    private double star;

    private long likes;

    private String title;

    private boolean is_deleted;

    private boolean is_hided;


    private PREFERSEX prefersex;

    private String mainPic;

    public void EntityToDTO(Review review){
        this.id=review.getId();
        this.hits = review.getHits();
        this.content = review.getContent();;
        this.star = review.getStar();
        this.likes = review.getLikes();
        this.title = review.getTitle();
        this.is_deleted= review.is_deleted();
        this.is_hided = review.is_hided();
        this.prefersex = review.getPrefersex();
        this.mainPic = review.getMainPic();
    }


}

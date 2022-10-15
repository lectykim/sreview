package com.sreviewonly.board.entites;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Getter


@EntityListeners(AuditingEntityListener.class)
@EntityScan
public class ReviewToHashtag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;



    private long reviewId;


    private long hashtagId;

    @Builder
    public ReviewToHashtag(long reviewId,long hashtagId){
        this.reviewId=reviewId;
        this.hashtagId=hashtagId;
    }

    public ReviewToHashtag() {

    }
}

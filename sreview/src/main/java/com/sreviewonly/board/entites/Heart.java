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
public class Heart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // mysql database에서 primary_key를 사용하는 방법.
    private long id;


    private long reviewId;


    private long userId;

    @Builder
    public Heart(long reviewId,long userId){
        this.reviewId=reviewId;
        this.userId=userId;

    }

    public Heart() {

    }
}

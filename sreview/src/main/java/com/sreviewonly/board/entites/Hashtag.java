package com.sreviewonly.board.entites;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter


@EntityListeners(AuditingEntityListener.class)
@EntityScan
public class Hashtag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    private String tagId;

    private long tagCnt;



    @Builder
    public Hashtag(String tagId,long tagCnt){
        this.tagId=tagId;
        this.tagCnt=tagCnt;
    }

    public Hashtag() {

    }
}

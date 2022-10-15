package com.sreviewonly.board.entites;

import com.sreviewonly.board.entites.enums.PREFERSEX;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter


@EntityListeners(AuditingEntityListener.class)
@EntityScan
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long hits;

    @Column(nullable = false)
    private String content;


    private double star;

    @Column(nullable = false)
    private String title;

    private boolean is_deleted;

    private boolean is_hided;

    private long likes;

    @Enumerated(EnumType.STRING)
    private PREFERSEX prefersex;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    private String mainPic;


    private LocalDateTime deletedDate;

    @OneToOne(fetch = FetchType.LAZY)
    Comment comment;



    @ManyToOne(fetch=FetchType.LAZY)
    private Product product;




    @Builder
    public Review(long hits,String content,double star,String title,boolean is_deleted,boolean is_hided,long likes,PREFERSEX prefersex,String mainPic){
        this.hits=hits;
        this.content=content;
        this.star=star;
        this.title=title;
        this.is_deleted=is_deleted;
        this.is_hided=is_hided;
        this.likes=likes;
        this.prefersex=prefersex;
        this.mainPic=mainPic;
    }

    public Review() {

    }

    public void setUser(User user){
        this.user=user;
    }
    public void setComment(Comment comment){
        this.comment=comment;
    }

    public void setProduct(Product product){
        this.product=product;
    }

}

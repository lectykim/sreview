package com.sreviewonly.board.entites;

import com.sreviewonly.board.entites.enums.PREFERSEX;
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
@Setter

@EntityListeners(AuditingEntityListener.class)
@EntityScan
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
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

    @OneToMany(mappedBy = "review",cascade = CascadeType.ALL)
    private List<ReviewToHashtag> reviewToHashtagList;

    @ManyToOne(fetch=FetchType.LAZY)
    private Product product;

}

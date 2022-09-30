package com.sreviewonly.board.entites;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
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
    @Setter
    private long id;

    private long hits;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String title;

    private boolean is_deleted;

    private boolean is_hided;

    private long likes;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;


    private LocalDateTime deletedDate;

    @OneToMany(mappedBy = "review" , cascade = CascadeType.ALL)
    List<Comment> comments = new ArrayList<>();











}

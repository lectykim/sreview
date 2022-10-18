package com.sreviewonly.board.entites;

import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter


@EntityListeners(AuditingEntityListener.class)
@EntityScan
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToOne(cascade=CascadeType.ALL, mappedBy = "comment")
    private Review review;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;


    private LocalDateTime deletedDate;

    @Builder
    public Comment(String content,User user){
        this.content=content;
        this.user=user;

    }


    public Comment() {

    }
}

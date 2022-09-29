package com.sreviewonly.board.entites;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review {

    @Id
    @GeneratedValue
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

    private Long likes;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedDate;

    @OneToMany(mappedBy = "review" , cascade = CascadeType.ALL)
    List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "review" , cascade = CascadeType.ALL)
    List<Product> products = new ArrayList<>();









}

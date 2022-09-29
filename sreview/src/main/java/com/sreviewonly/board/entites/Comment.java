package com.sreviewonly.board.entites;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter
public class Comment {
    @Id
    @GeneratedValue
    @Column(name = "content_id")
    private long id;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Review review;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedDate;
}

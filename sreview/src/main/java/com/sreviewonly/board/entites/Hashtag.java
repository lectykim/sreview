package com.sreviewonly.board.entites;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter

@EntityListeners(AuditingEntityListener.class)
@EntityScan
public class Hashtag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private long id;

    private String tagId;

    private Long tagCnt;

    @OneToMany(mappedBy = "hashtag",cascade = CascadeType.ALL)
    private List<ReviewToHashtag> reviewToHashtagList;
}

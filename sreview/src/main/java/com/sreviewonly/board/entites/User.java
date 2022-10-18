package com.sreviewonly.board.entites;

import com.sreviewonly.board.entites.enums.PREFERSEX;
import com.sreviewonly.board.entites.enums.ROLE;
import com.sreviewonly.board.entites.enums.VIPRANK;
import lombok.*;
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

@EntityListeners(AuditingEntityListener.class)
@EntityScan
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // mysql database에서 primary_key를 사용하는 방법.

    private long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String nickname;

    @Column(length = 12,nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private VIPRANK viprank;

    @Enumerated(EnumType.STRING)
    private ROLE role;

    private long point;

    private String profile_pic;

    private String background_pic;

    private boolean isBanned;

    @Enumerated(EnumType.STRING)
    private PREFERSEX prefersex;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;


    private LocalDateTime deletedDate;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<Comment> comments;

    @OneToMany(mappedBy = "user",
    cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();



    @Builder
    public User(String email, String nickname,String password , VIPRANK viprank,ROLE role ,long point,String profile_pic,String background_pic,boolean isBanned, PREFERSEX prefersex){
        this.email=email;
        this.nickname=nickname;
        this.password=password;
        this.viprank=viprank;
        this.role=role;
        this.point=point;
        this.profile_pic=profile_pic;
        this.background_pic=background_pic;
        this.isBanned=isBanned;
        this.prefersex=prefersex;
    }


    public User() {

    }
}

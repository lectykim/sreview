package com.sreviewonly.board.entites;

import com.sreviewonly.board.builder.CommonBuilder;
import com.sreviewonly.board.dto.UserDTO;
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

    private User(UserBuilder builder){
        this.email = builder.email;
        this.nickname = builder.nickname;
        this.viprank = builder.viprank;
        this.role = builder.role;
        this.password = builder.password;
        this.point = builder.point;
        this.profile_pic = builder.profile_pic;
        this.background_pic = builder.background_pic;
        this.isBanned = builder.isBanned;
        this.prefersex = builder.prefersex;
    }

    public static class UserBuilder implements CommonBuilder<User>{
        private String email;
        private String nickname;
        private String password;
        private VIPRANK viprank;
        private ROLE role;
        private long point;
        private String profile_pic;
        private String background_pic;
        private boolean isBanned;
        private PREFERSEX prefersex;



        public UserBuilder(UserDTO userDTO){
            this.email = userDTO.getEmail();
            this.nickname = userDTO.getNickname();
            this.viprank = userDTO.getViprank();
            this.role = userDTO.getRole();
            this.password = userDTO.getPassword();
            this.point = userDTO.getPoint();
            this.profile_pic = userDTO.getProfile_pic();
            this.background_pic = userDTO.getBackground_pic();
            this.isBanned = userDTO.isBanned();
            this.prefersex = userDTO.getPrefersex();
        }

        @Override
        public User build(){
            return new User(this);
        }
    }
}

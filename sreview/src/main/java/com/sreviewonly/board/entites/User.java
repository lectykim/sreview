package com.sreviewonly.board.entites;

import com.sreviewonly.board.entites.enums.PREFERSEX;
import com.sreviewonly.board.entites.enums.ROLE;
import com.sreviewonly.board.entites.enums.VIPRANK;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter
public class User {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
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

    private boolean is_banned;


    @Enumerated(EnumType.STRING)
    private PREFERSEX prefersex;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedDate;



}

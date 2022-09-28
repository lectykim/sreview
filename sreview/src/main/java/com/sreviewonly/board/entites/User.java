package com.sreviewonly.board.entites;

import com.sreviewonly.board.entites.enums.PREFERSEX;
import com.sreviewonly.board.entites.enums.RANK;
import com.sreviewonly.board.entites.enums.ROLE;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
    private RANK rank;

    private long point;

    private String profile_pic;

    private String background_pic;

    private boolean is_banned;

    private ROLE role;

    private PREFERSEX prefersex;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedDate;

}

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
public class Keeping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "keeping_id")
    private long id;

    private String username;

    private String location;

    private Date promiseDay;

}

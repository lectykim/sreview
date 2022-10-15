package com.sreviewonly.board.dto;

import com.sreviewonly.board.entites.enums.PREFERSEX;
import com.sreviewonly.board.entites.enums.ROLE;
import com.sreviewonly.board.entites.enums.VIPRANK;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
public class UserDTO {

    private long id;

    private String email;


    private String nickname;


    private String password;


    private VIPRANK viprank;


    private ROLE role;

    private long point;

    private String profile_pic;

    private String background_pic;

    private boolean is_banned;


    private PREFERSEX prefersex;

}

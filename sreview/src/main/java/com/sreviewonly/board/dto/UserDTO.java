package com.sreviewonly.board.dto;

import com.sreviewonly.board.entites.User;
import com.sreviewonly.board.entites.enums.PREFERSEX;
import com.sreviewonly.board.entites.enums.ROLE;
import com.sreviewonly.board.entites.enums.VIPRANK;
import lombok.Builder;
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

    private boolean isBanned;


    private PREFERSEX prefersex;


    public UserDTO(User user){
        this.id = user.getId();
        this.email = user.getEmail();
        this.nickname = user.getNickname();
        this.password = user.getPassword();
        this.viprank = user.getViprank();
        this.role = user.getRole();
        this.point = user.getPoint();
        this.profile_pic = user.getProfile_pic();
        this.background_pic = user.getBackground_pic();
        this.isBanned = user.isBanned();
        this.prefersex = user.getPrefersex();
    }


}

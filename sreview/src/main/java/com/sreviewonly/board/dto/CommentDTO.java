package com.sreviewonly.board.dto;

import com.sreviewonly.board.entites.Review;
import com.sreviewonly.board.entites.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Setter
@Getter
public class CommentDTO {

    private long id;

    private String content;

    private User user;

    private Review review;
}

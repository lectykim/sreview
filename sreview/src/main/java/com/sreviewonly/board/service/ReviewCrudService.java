package com.sreviewonly.board.service;

import com.sreviewonly.board.entites.Product;
import com.sreviewonly.board.entites.Review;
import com.sreviewonly.board.entites.User;
import com.sreviewonly.board.entites.enums.PREFERSEX;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewCrudService {
    public Review findReview(Long id);




}

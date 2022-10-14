package com.sreviewonly.board.service;

import com.sreviewonly.board.entites.Product;
import com.sreviewonly.board.entites.Review;
import com.sreviewonly.board.entites.User;
import org.springframework.stereotype.Service;

@Service
public interface ReviewCrudService {
    public Review findReview(Long id);


}

package com.sreviewonly.board.service;

import com.sreviewonly.board.entites.Product;
import com.sreviewonly.board.entites.Review;
import com.sreviewonly.board.entites.User;
import com.sreviewonly.board.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewCrudServiceImpl implements ReviewCrudService{

    @Autowired
    public ReviewRepository reviewRepository;



    @Override
    public Review findReview(Long id) {
        return reviewRepository.findById(id).get();
    }


}

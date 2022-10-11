package com.sreviewonly.board.service;

import com.sreviewonly.board.entites.Product;
import com.sreviewonly.board.entites.enums.PREFERSEX;
import com.sreviewonly.board.repositories.ProductRepository;
import com.sreviewonly.board.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ArrangeServiceImpl implements ArrangeService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public List<Product> ArrangeReviewToPreferSex(PREFERSEX prefersex) {

        List<Product> list =  new ArrayList<>();



        return list;
    }
}

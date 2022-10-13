package com.sreviewonly.board.service;

import com.sreviewonly.board.entites.Product;
import com.sreviewonly.board.entites.Review;
import com.sreviewonly.board.entites.enums.PREFERSEX;
import com.sreviewonly.board.repositories.ProductRepository;
import com.sreviewonly.board.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArrangeServiceImpl implements ArrangeService {


    @Autowired
    ProductRepository productRepository;

    @Autowired
    ReviewRepository reviewRepository;


    //Review Id를 대상으로 상품의 객체를 리스트에 담아 반환하는 함수

    @Override
    public List<Review> findReviewByPreferSex(PREFERSEX prefersex) {
        List<Review> list = reviewRepository.findReviewByprefersex(prefersex);
        return list;
    }

    @Override
    public List<Product> findProductByPreferSex(PREFERSEX prefersex) {
        List<Product> list = productRepository.findProductByProductPreferSex(prefersex);
        return list;
    }



}




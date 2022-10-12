package com.sreviewonly.board.service;

import com.sreviewonly.board.entites.Product;
import com.sreviewonly.board.entites.ProductToReview;
import com.sreviewonly.board.entites.Review;
import com.sreviewonly.board.entites.enums.PREFERSEX;
import com.sreviewonly.board.repositories.ProductRepository;
import com.sreviewonly.board.repositories.ProductToReviewRepository;
import com.sreviewonly.board.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArrangeServiceImpl implements ArrangeService {


    @Autowired
    ProductRepository productRepository;


    @Autowired
    ProductToReviewRepository productToReviewRepository;


    @Autowired
    ReviewRepository reviewRepository;


    //Review Id를 대상으로 상품의 객체를 리스트에 담아 반환하는 함수
    @Override
    public List<Product> findProductByReviewId(long id) {

        Review review = reviewRepository.findById(id).get();
        List<ProductToReview> products = productToReviewRepository.findProductByReview(review);
        List<Product> productList = new ArrayList<>();
        for (ProductToReview productToReview : products) {
            productList.add(productToReview.getProduct());
        }


        return productList;
    }

    @Override
    public List<Review> findReviewByProduct(Product product) {
        List<ProductToReview> reviews = productToReviewRepository.findReviewByProduct(product);
        List<Review> reviewList = new ArrayList<>();
        for (ProductToReview productToReview : reviews) {
            reviewList.add(productToReview.getReview());
        }

        return reviewList;
    }

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




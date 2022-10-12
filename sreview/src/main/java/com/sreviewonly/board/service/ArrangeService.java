package com.sreviewonly.board.service;

import com.sreviewonly.board.entites.Product;
import com.sreviewonly.board.entites.Review;
import com.sreviewonly.board.entites.enums.PREFERSEX;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArrangeService {



    List<Product> findProductByReviewId(long id);

    List<Review> findReviewByProduct(Product product);

    List<Review> findReviewByPreferSex(PREFERSEX prefersex);

    List<Product> findProductByPreferSex(PREFERSEX prefersex);


}

package com.sreviewonly.board.service;

import com.sreviewonly.board.entites.Product;
import com.sreviewonly.board.entites.Review;
import com.sreviewonly.board.entites.enums.PREFERSEX;
import com.sreviewonly.board.repositories.ProductRepository;
import com.sreviewonly.board.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArrangeServiceImpl implements ArrangeService {


    @Autowired
    ProductRepository productRepository;


    @Autowired
    ReviewRepository reviewRepository;




    @Override
    public List<Review> findReviewByPreferSexLimitPaging(PREFERSEX prefersex, Map<String,Integer> map,int curPage) {
        PageRequest pageRequest;

        int left = map.get("perPage")*(curPage-1);
        System.out.println("left : " + left);
        System.out.println("right : " + map.get("perPage")*curPage);
        pageRequest = PageRequest.of(curPage-1,15);


        Page<Review> reviewPage = reviewRepository.findReviewByprefersexOrderByIdDesc(prefersex,pageRequest);
        return reviewPage.getContent();
    }

    @Override
    public List<Product> findProductByPreferSex(PREFERSEX prefersex) {
        return null;
    }
}




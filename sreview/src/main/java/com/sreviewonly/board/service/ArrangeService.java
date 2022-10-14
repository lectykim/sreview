package com.sreviewonly.board.service;

import com.sreviewonly.board.entites.Product;
import com.sreviewonly.board.entites.Review;
import com.sreviewonly.board.entites.enums.PREFERSEX;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface ArrangeService {







    List<Review> findReviewByPreferSexLimitPaging(PREFERSEX prefersex,Map<String,Integer> map,int curPage);

    List<Product> findProductByPreferSex(PREFERSEX prefersex);




}

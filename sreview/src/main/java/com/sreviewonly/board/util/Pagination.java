package com.sreviewonly.board.util;

import com.sreviewonly.board.entites.enums.PREFERSEX;
import com.sreviewonly.board.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Pagination {


    @Autowired
    public ReviewRepository reviewRepository;

    public Map<String, Integer> findPageInformation(int perPage, PREFERSEX prefersex) {
        Map<String,Integer> pageMap = new HashMap<>();
        int allPage = reviewRepository.countByprefersex(prefersex).intValue();
        pageMap.put("perPage",perPage);
        pageMap.put("allPage",allPage);
        pageMap.put("balancePage",allPage%perPage);
        pageMap.put("pageSize",allPage/perPage+1);

        return pageMap;
    }
}
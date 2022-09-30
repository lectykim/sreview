package com.sreviewonly.board.repositories;

import com.sreviewonly.board.entites.Heart;
import com.sreviewonly.board.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HeartRepository extends JpaRepository<Heart,Long> {
    public List<Heart> findByReviewId(long id);

}

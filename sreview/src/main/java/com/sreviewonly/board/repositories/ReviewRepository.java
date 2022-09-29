package com.sreviewonly.board.repositories;

import com.sreviewonly.board.entites.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}

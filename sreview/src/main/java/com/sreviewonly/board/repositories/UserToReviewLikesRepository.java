package com.sreviewonly.board.repositories;

import com.sreviewonly.board.entites.Review;
import com.sreviewonly.board.entites.User;
import com.sreviewonly.board.entites.UserToReviewLikes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface UserToReviewLikesRepository extends JpaRepository<UserToReviewLikes,Long> {
    @Transactional
    public void deleteByReviewAndUser(Review review,User user);
}

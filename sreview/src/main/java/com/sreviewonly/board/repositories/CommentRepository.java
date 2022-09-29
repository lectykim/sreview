package com.sreviewonly.board.repositories;

import com.sreviewonly.board.entites.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}

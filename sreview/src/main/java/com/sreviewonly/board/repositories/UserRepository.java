package com.sreviewonly.board.repositories;

import com.sreviewonly.board.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}

package com.sreviewonly.board.repositories;

import com.sreviewonly.board.entites.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}

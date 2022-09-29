package com.sreviewonly.board.entites;

import com.sreviewonly.board.entites.enums.PREFERSEX;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private long id;

    private String productPic;

    private String productName;

    private String productShop;

    private Long productPrice;

    private PREFERSEX productPreferSex;

    @ManyToOne(fetch = FetchType.LAZY)
    private Review review;

}

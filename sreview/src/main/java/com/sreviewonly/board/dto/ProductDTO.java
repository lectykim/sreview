package com.sreviewonly.board.dto;

import com.sreviewonly.board.entites.Product;
import com.sreviewonly.board.entites.enums.PREFERSEX;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {

    private long id;

    private String productPic;

    private String name;

    private String shopName;

    private long price;

    private String shopLink;

    private PREFERSEX preferSex;

    public ProductDTO(Product product){
        this.id= product.getId();
        this.productPic = product.getProductPic();
        this.name = product.getName();
        this.shopName = product.getShopName();
        this.price = product.getPrice();
        this.shopLink = product.getShopLink();
        this.preferSex = product.getPreferSex();
    }

}

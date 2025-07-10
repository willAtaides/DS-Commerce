package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Product;
import jakarta.persistence.Column;

public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String ImgUrl;


    public ProductDTO(){

    }

    public ProductDTO(Long id, String name, String description, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        ImgUrl = imgUrl;
    }

    public ProductDTO(Product entity) {
        id = entity.getId();
        name =entity.getName();
        description = entity.getDescription();
        price = entity.getPrice();
        ImgUrl = entity.getImgUrl();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return ImgUrl;
    }
}

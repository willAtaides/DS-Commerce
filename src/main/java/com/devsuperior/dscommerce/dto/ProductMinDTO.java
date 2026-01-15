package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductMinDTO {
    private Long id;
    private String name;
    private Double price;
    private String ImgUrl;

    public ProductMinDTO(){
    }
    public ProductMinDTO(Long id, String name, String description, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        ImgUrl = imgUrl;
    }
    public ProductMinDTO(Product entity) {
        id = entity.getId();
        name =entity.getName();
        price = entity.getPrice();
        ImgUrl = entity.getImgUrl();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return ImgUrl;
    }
}

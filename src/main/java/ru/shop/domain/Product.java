package ru.shop.domain;

import java.util.UUID;

public class Product implements Domain{
    private UUID id;
    private String name;
    private Long cost;
    private ProductType productType;

    public Product(UUID id, String name, Long cost, ProductType productType) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.productType = productType;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", productType=" + productType +
                '}';
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getCost() {
        return cost;
    }

    public ProductType getProductType() {
        return productType;
    }



}

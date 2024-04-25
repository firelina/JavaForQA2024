package ru.shop.domain;

import java.util.UUID;

public class Order implements Domain {
    private UUID id;
    private UUID customerId;
    private UUID productId;
    private Long cost;
    private Long amount;

    public Order() {

    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", productId=" + productId +
                ", cost=" + cost +
                ", amount=" + amount +
                '}';
    }

    public Order(UUID id, UUID customerId, UUID productId, Long count, Long amount) {
        this.id = id;
        this.customerId = customerId;
        this.productId = productId;
        this.cost = count;
        this.amount = amount;
    }

    public UUID getId() {
        return id;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public UUID getProductId() {
        return productId;
    }

    public Long getCost() {
        return cost;
    }

    public Long getAmount() {
        return amount;
    }


}

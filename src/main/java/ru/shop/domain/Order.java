package ru.shop.domain;

import java.util.UUID;

public class Order implements Domain {
    private UUID id;
    private UUID customerId;
    private UUID productId;
    private Long count;
    private Long amount;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", productId=" + productId +
                ", cost=" + count +
                ", amount=" + amount +
                '}';
    }

    public Order(UUID id, UUID customerId, UUID productId, Long count, Long amount) {
        this.id = id;
        this.customerId = customerId;
        this.productId = productId;
        this.count = count;
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

    public Long getCount() {
        return count;
    }

    public Long getAmount() {
        return amount;
    }


}

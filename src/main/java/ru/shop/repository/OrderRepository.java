package ru.shop.repository;

import org.springframework.stereotype.Repository;
import ru.shop.domain.Domain;
import ru.shop.domain.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Repository
public class OrderRepository implements CommonRepository{
    private final ArrayList<Order> orders;
    public OrderRepository() {
        this.orders = new ArrayList<>();
    }
    @Override
    public void save(Domain order) {
        orders.add((Order) order);
    }


    @Override
    public List<Domain> findAll() {
        return new ArrayList<>(orders);
    }
}

package ru.shop.repository;

import ru.shop.domain.Domain;
import ru.shop.domain.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        return orders.stream().map(o-> (Order)o).collect(Collectors.toList());
    }
}

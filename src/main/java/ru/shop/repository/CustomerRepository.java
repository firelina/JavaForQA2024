package ru.shop.repository;

import ru.shop.domain.Customer;
import ru.shop.domain.Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerRepository implements CommonRepository{
    public CustomerRepository() {
        this.customers = new ArrayList<>();
    }

    private final ArrayList<Customer> customers;
    @Override
    public void save(Domain customer){
        customers.add((Customer) customer);
    }

    @Override
    public List<Domain> findAll() {
        return customers.stream().map(c -> (Domain)c).collect(Collectors.toList());
    }


}

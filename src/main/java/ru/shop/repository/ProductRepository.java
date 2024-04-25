package ru.shop.repository;

import org.springframework.stereotype.Repository;
import ru.shop.domain.Domain;
import ru.shop.domain.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Repository
public class ProductRepository implements CommonRepository{
    private ArrayList<Product> products;
    public ProductRepository() {
        this.products = new ArrayList<>();
    }

    @Override
    public void save(Domain product) {
        products.add((Product) product);
    }


    @Override
    public List<Domain> findAll() {
        return products.stream().map( p -> (Domain)p).collect(Collectors.toList());
    }
}

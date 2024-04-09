package ru.shop.repository;

import ru.shop.domain.Domain;

import java.util.List;

public interface CommonRepository {
    void save(Domain domain);
    List<Domain> findAll();
}

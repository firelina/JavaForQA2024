package ru.shop.sevices;

import ru.shop.domain.Domain;

import java.util.List;

public interface CommonService {
    void save(Domain domain);
    List<Domain> findAll();
}

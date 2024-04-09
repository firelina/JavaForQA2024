package ru.shop.sevices;

import ru.shop.domain.Domain;
import ru.shop.repository.CommonRepository;

import java.util.List;

public class CustomerService implements CommonService{
    private final CommonRepository customerRepository;
    public CustomerService(CommonRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Override
    public void save(Domain domain) {
        customerRepository.save(domain);
    }

    @Override
    public List<Domain> findAll() {
        return customerRepository.findAll();
    }
}

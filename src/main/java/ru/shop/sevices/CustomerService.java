package ru.shop.sevices;

import org.springframework.stereotype.Service;
import ru.shop.domain.Customer;
import ru.shop.domain.Domain;
import ru.shop.domain.Product;
import ru.shop.exception.EntityNotFoundException;
import ru.shop.repository.CommonRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
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
    public Optional<Customer> findById(UUID id) throws EntityNotFoundException {
        List<Customer> customers = customerRepository.findAll().stream().map(d -> (Customer)d).collect(Collectors.toList());

        return Optional.of(customers.stream().filter(c -> c.getId().equals(id)).findFirst().orElseThrow(()-> new EntityNotFoundException("customer not found")));
    }
}

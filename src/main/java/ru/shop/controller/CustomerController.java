package ru.shop.controller;

import org.springframework.web.bind.annotation.*;
import ru.shop.domain.Customer;
import ru.shop.domain.Domain;
import ru.shop.domain.Order;
import ru.shop.exception.EntityNotFoundException;
import ru.shop.sevices.CustomerService;
import ru.shop.sevices.OrderService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;
    private final OrderService orderService;

    public CustomerController(CustomerService customerService, OrderService orderService) {
        this.customerService = customerService;
        this.orderService = orderService;
    }

    @GetMapping
    public List<Domain> getAllCustomers() {
        return customerService.findAll();
    }
    @PostMapping
    public void save(@RequestBody Customer customer) {
        customerService.save(customer);
    }
    @GetMapping("/customer/{customerId}")
    public Optional<Customer> getByCustomerId(UUID customerId) throws EntityNotFoundException {
        return customerService.findById(customerId);
    }
    @GetMapping("/customer/{customerId}/orders")
    public List<Order> getByCustomer(UUID customerId) throws EntityNotFoundException {
        Customer cust = customerService.findById(customerId).orElse(null);
        return orderService.findByCustomer(cust);
    }
    @GetMapping("/customer/{customerId}/total")
    public long getCustomerTotal(UUID customerId) throws EntityNotFoundException {
        Customer customer = customerService.findById(customerId).orElse(null);
        return orderService.getTotalCustomerAmount(customer);
    }


}

package ru.shop.controller;

import org.springframework.web.bind.annotation.*;
import ru.shop.domain.Customer;
import ru.shop.domain.Domain;
import ru.shop.domain.Order;
import ru.shop.domain.Product;
import ru.shop.exception.BadOrderCountException;
import ru.shop.exception.EntityNotFoundException;
import ru.shop.sevices.CustomerService;
import ru.shop.sevices.OrderService;
import ru.shop.sevices.ProductService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;
    private final ProductService productService;
    private final CustomerService customerService;

    public OrderController(OrderService orderService, ProductService productService, CustomerService customerService) {
        this.orderService = orderService;
        this.productService = productService;
        this.customerService = customerService;
    }

    @GetMapping
    public List<Domain> getAllOrders() {
        return orderService.findAll();
    }
    @PostMapping
    public void save(UUID productId, UUID customerId, Long count) throws EntityNotFoundException, BadOrderCountException {
        Product product = productService.findById(productId).orElse(null);
        Customer customer = customerService.findById(customerId).orElse(null);
        orderService.add(customer, product, count);
    }
    @GetMapping("/{id}") public Optional<Order> getById(@PathVariable UUID id) throws EntityNotFoundException {
        return orderService.findById(id);
    }
}

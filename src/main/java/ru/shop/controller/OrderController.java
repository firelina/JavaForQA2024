package ru.shop.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.shop.model.Order;
import ru.shop.repository.CustomerRepository;
import ru.shop.service.OrderService;
import ru.shop.service.ProductService;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;
    private final ProductService productService;
    private final CustomerRepository customerService;

    @GetMapping
    public List<Order> getAll() {
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public Order getById(@PathVariable UUID id) {
        return orderService.getById(id);
    }
    @PostMapping
    public void save(UUID productId, UUID customerId, int count) {
        orderService.add(customerService.findById(customerId).orElse(null),
                productService.findById(productId).orElse(null), count);
    }


}
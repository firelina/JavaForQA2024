package ru.shop.sevices;

import ru.shop.domain.Customer;
import ru.shop.domain.Domain;
import ru.shop.domain.Order;
import ru.shop.domain.Product;
import ru.shop.exception.BadOrderCountException;
import ru.shop.repository.CommonRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class OrderService implements CommonService{
    private final CommonRepository orderRepository;

    public OrderService(CommonRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void save(Domain domain) {
        orderRepository.save(domain);
    }

    @Override
    public List<Domain> findAll() {
        return orderRepository.findAll();
    }

    public void add(Customer customer, Product product, Long count) throws BadOrderCountException {
        if (count < 0) {
            throw new BadOrderCountException("count is less than zero");
        }
        Order order = new Order(UUID.randomUUID(), customer.getId(), product.getId(), count, count * product.getCost());
        this.save(order);
    }
    public List<Order> findByCustomer (Customer customer) {
        List<Order> orders = this.findAll().stream().map(d -> (Order)d).collect(Collectors.toList());
        return orders.stream().filter(o -> o.getCustomerId() == customer.getId()).collect(Collectors.toList());
    }
    public Long getTotalCustomerAmount(Customer customer) {
        return this.findByCustomer(customer).stream().map(o -> o.getAmount()).mapToLong(v -> v).sum();
    }
}

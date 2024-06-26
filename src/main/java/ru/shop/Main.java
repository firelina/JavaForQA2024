package ru.shop;

import ru.shop.domain.Customer;
import ru.shop.domain.Order;
import ru.shop.domain.Product;
import ru.shop.domain.ProductType;
import ru.shop.exception.BadOrderCountException;
import ru.shop.repository.CustomerRepository;
import ru.shop.repository.OrderRepository;
import ru.shop.repository.ProductRepository;
import ru.shop.sevices.CustomerService;
import ru.shop.sevices.OrderService;
import ru.shop.sevices.ProductService;

import java.util.Arrays;
import java.util.UUID;

public class Main {

    public static void main(String[] args) throws BadOrderCountException {
        Customer customer = new Customer(UUID.randomUUID(), "Polina", "89123347898", 20L);
        Product apple = new Product(UUID.randomUUID(), "apple", 3L, ProductType.GOOD);
        Product washHands = new Product(UUID.randomUUID(), "wash hands", 45L, ProductType.SERVICE);
        Product product = new Product(UUID.randomUUID(), "product", 56L, ProductType.SERVICE);
        Order order = new Order(UUID.randomUUID(), customer.getId(), apple.getId(), 2L, 1L);
        System.out.println(customer.toString());

        System.out.println(apple.toString());
        System.out.println(washHands.toString());
        System.out.println(order.toString());
        OrderRepository orderRepository = new OrderRepository();
        CustomerRepository customerRepository = new CustomerRepository();
        ProductRepository productRepository = new ProductRepository();
        CustomerService customerService = new CustomerService(customerRepository);
        ProductService productService = new ProductService(productRepository);
        OrderService orderService = new OrderService(orderRepository);
        Customer customer1 = new Customer(UUID.randomUUID(), "Anna", "89781234556", 25L);
        customerService.save(customer);
        customerService.save(customer1);
        productService.save(apple);
        productService.save(washHands);
        productService.save(product);
        try {
            orderService.add(customer, apple, apple.getCost());
            orderService.add(customer, washHands, washHands.getCost());
            orderService.add(customer1, apple, apple.getCost());
            orderService.add(customer1, apple, -1L);
            orderService.add(customer1, apple, apple.getCost());
        }
        catch (BadOrderCountException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Сумма заказа равна " + orderService.getTotalCustomerAmount(customer) + " у покупателя " + customer.getName());
        System.out.println("Сумма заказа равна " + orderService.getTotalCustomerAmount(customer1)  + " у покупателя " + customer1.getName());
        System.out.println("Всего заказов " + orderService.findAll().stream().count());
        System.out.println("Количество заказов " + orderService.findByCustomer(customer).stream().count() + " покупателя " + customer.getName());
        System.out.println("Количество заказов " + orderService.findByCustomer(customer1).stream().count() + " покупателя " + customer1.getName());
        System.out.println("Количество заказчиков " + customerService.findAll().stream().count());
        System.out.println("Всего товаров " + productService.findAll().stream().count());
        System.out.println("Товаров типа SERVICE " + productService.findByProductType(ProductType.SERVICE).stream().count());
        System.out.println("Товаров типа GOOD " + productService.findByProductType(ProductType.GOOD).stream().count());
    }

}
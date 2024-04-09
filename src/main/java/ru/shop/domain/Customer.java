package ru.shop.domain;

import java.util.UUID;

public class Customer implements Domain {
    private UUID id;
    private String name;
    private String phone;
    private Long age;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                '}';
    }

    public Customer(UUID id, String name, String phone, Long age) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.age = age;
    }

    public UUID getId() {
        return id;
    }

     public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public Long getAge() {
        return age;
    }


}

package com.jpamodulospring;

import com.jpamodulospring.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaModuloSpringApplication implements CommandLineRunner {

    @Autowired
    private OrderRepository orderRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaModuloSpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        orderRepository.findAll().forEach(System.out::println);
    }
}

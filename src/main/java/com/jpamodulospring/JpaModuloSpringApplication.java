package com.jpamodulospring;

import com.jpamodulospring.entities.BillEntity;
import com.jpamodulospring.entities.OrderEntity;
import com.jpamodulospring.entities.ProductsEntity;
import com.jpamodulospring.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class JpaModuloSpringApplication implements CommandLineRunner {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCatalogRepository productCatalogRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaModuloSpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*
        orderRepository.findAll().forEach(System.out::println);
        billRepository.findAll().forEach(System.out::println);

        var bill = BillEntity.builder()
                .rfc("POIU452135RE1")
                .totalAmount(BigDecimal.TEN)
                .id("b-18")
                .build();

        var order = OrderEntity.builder().createdAt(LocalDateTime.now())
                .clientName("Angel")
                .bill(bill)
                .build();

        orderRepository.save(order);

        //Para un update
        var order = orderRepository.findById(17L).get();
        order.setClientName("Angel Juan");
        orderRepository.save(order);

        //Se crean dos productos que se ligan a una orden y a los productos se les asigna la orden correspondiente
        var order = this.orderRepository.findById(1L).orElseThrow();
        var product1 = ProductsEntity.builder().quantity(BigInteger.ONE).build();
        var product2 = ProductsEntity.builder().quantity(BigInteger.TWO).build();

        var products = List.of(product1, product2);
        order.setProducts(products);

        products.forEach(product -> product.setOrder(order));

        this.orderRepository.save(order);


        this.productCatalogRepository.findAll().forEach(System.out::println);


        // se pobla la tabla muchos a muchos
        final var HOME = this.categoryRepository.findById(1L).orElseThrow();
        final var OFFICE = this.categoryRepository.findById(2L).orElseThrow();

        this.productCatalogRepository.findAll().forEach(product -> {
            if(product.getDescription().contains("home")){
                product.addCategory(HOME);
            }
            if(product.getDescription().contains("office")){
                product.addCategory(OFFICE);
            }
            this.productCatalogRepository.save(product);
        });
         */
    }
}

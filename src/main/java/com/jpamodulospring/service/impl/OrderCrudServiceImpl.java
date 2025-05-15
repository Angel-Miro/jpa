package com.jpamodulospring.service.impl;

import com.jpamodulospring.dtos.BillDTO;
import com.jpamodulospring.dtos.OrderDTO;
import com.jpamodulospring.dtos.ProductsDTO;
import com.jpamodulospring.entities.BillEntity;
import com.jpamodulospring.entities.OrderEntity;
import com.jpamodulospring.entities.ProductsEntity;
import com.jpamodulospring.repositories.OrderRepository;
import com.jpamodulospring.repositories.ProductCatalogRepository;
import com.jpamodulospring.service.OrdersCrudService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderCrudServiceImpl implements OrdersCrudService {

    private final OrderRepository orderRepository;
    private final ProductCatalogRepository productCatalogRepository;

    @Override
    public String create(OrderDTO order) {
        final var insert = this.mapOrderFromDto(order);
        return this.orderRepository.save(insert).toString();
    }

    @Override
    public OrderDTO read(Long id) {
        return this.mapOrderFromEntity(orderRepository.findById(id).orElseThrow());
    }

    @Override
    public OrderDTO readCustome(Long id) {
        return this.mapOrderFromEntityCustom(orderRepository.findById(id).orElseThrow());
    }

    @Override
    public OrderDTO update(OrderDTO order, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }


    private OrderDTO mapOrderFromEntity(OrderEntity orderEntity) {
        //se mapea por reflection , solo los campos que hagan match con el nombrre
        final var mapper = new ModelMapper();
        return mapper.map(orderEntity, OrderDTO.class);
    }

    private OrderDTO mapOrderFromEntityCustom(OrderEntity orderEntity) {
        final var modMap = new ModelMapper();
        modMap.typeMap(ProductsEntity.class, ProductsDTO.class)
                .addMappings(mapper -> mapper.map(
                        e -> e.getCatalog().getName(), ProductsDTO::setName
                ));
        return modMap.map(orderEntity, OrderDTO.class);
    }

    private OrderEntity mapOrderFromDto(OrderDTO orderDTO) {
        final var orderResponse = new OrderEntity();
        final var modMap = new ModelMapper();
        //log.info("Before {}" , orderResponse);
        modMap.typeMap(BillDTO.class, BillEntity.class)
                .addMappings(mapper -> mapper.map(
                        BillDTO::getIdBill, BillEntity::setId
                ));
        //log.info("After {}" , orderResponse);
        this.getAndSetProducts(orderDTO.getProducts(), orderResponse);
        //log.info("After with products {}" , orderResponse);
        return orderResponse;
    }

    private void getAndSetProducts(List<ProductsDTO> products, OrderEntity orderEntity) {
        products.forEach(product -> {
            final var productsFromCatalog = this.productCatalogRepository.findByName(product.getName()).orElseThrow();
            final var productEntity = ProductsEntity.builder().quantity(BigInteger.valueOf(product.getQuantity())).catalog(productsFromCatalog).build();

            orderEntity.addProduct(productEntity);
            productEntity.setOrder(orderEntity);
        });
    }
}

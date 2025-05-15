package com.jpamodulospring.controller;

import com.jpamodulospring.dtos.OrderDTO;
import com.jpamodulospring.service.OrdersCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "order/")
public class OrderController {

    private final OrdersCrudService orderCrudService;

    @GetMapping(path = "id/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id){
        return ResponseEntity.ok(this.orderCrudService.read(id));
    }

    @GetMapping(path = "id-custome/{id}")
    public ResponseEntity<OrderDTO> getOrderByIdCustome(@PathVariable Long id){
        return ResponseEntity.ok(this.orderCrudService.readCustome(id));
    }

    @PostMapping
    public ResponseEntity<Void> addOrders(@RequestBody OrderDTO dto){
        var path = "order/" + this.orderCrudService.create(dto);
        return ResponseEntity.created(URI.create(path)).build();
    }

}

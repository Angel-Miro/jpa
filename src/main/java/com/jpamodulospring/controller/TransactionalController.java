package com.jpamodulospring.controller;


import com.jpamodulospring.service.TransactionalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(path = "transaction/")
@RequiredArgsConstructor
public class TransactionalController {

    private final TransactionalService transactionalService;


    public ResponseEntity<Map<String, String>> startTransaction(@RequestParam Long id) {
        this.transactionalService.executeTransaction(id);
        return ResponseEntity.ok(Map.of(":: Transaction ::", "OK"));
    }
}

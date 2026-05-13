package com.carniceria.isidro.isidrocarniceria.orders.details.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carniceria.isidro.isidrocarniceria.orders.details.entity.Detail;
import com.carniceria.isidro.isidrocarniceria.orders.details.service.DetailService;

@RestController
@RequestMapping("/api/orders/details")
public class DetailController {

    private final DetailService detailService;
    public DetailController(DetailService detailService) {
        this.detailService = detailService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Detail> getDetailById(@PathVariable Long id) {
        return detailService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    
}

package com.carniceria.isidro.isidrocarniceria.products.pricehistory.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carniceria.isidro.isidrocarniceria.products.pricehistory.dto.PriceHisotoryResponseDTO;
import com.carniceria.isidro.isidrocarniceria.products.pricehistory.service.PriceHistoryService;

@RestController
@RequestMapping("api/priceHistory")
public class PriceHistoryController {

    public PriceHistoryService priceHistoryService;

    public PriceHistoryController(PriceHistoryService priceHistoryService) {
        this.priceHistoryService = priceHistoryService;
    }

    @RequestMapping("/{id}")
    public ResponseEntity<PriceHisotoryResponseDTO> getPriceHistoryById(@PathVariable Long id) {
        Optional<PriceHisotoryResponseDTO> priceHistory = priceHistoryService.getPriceHistoryById(id);
        return priceHistory.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}

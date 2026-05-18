package com.carniceria.isidro.isidrocarniceria.products.pricehistory.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.carniceria.isidro.isidrocarniceria.mapper.Mapper;
import com.carniceria.isidro.isidrocarniceria.products.pricehistory.dto.PriceHisotoryResponseDTO;
import com.carniceria.isidro.isidrocarniceria.products.pricehistory.entity.PriceHistory;
import com.carniceria.isidro.isidrocarniceria.products.pricehistory.repository.PriceHistoryRepository;

@Service
public class PriceHistoryService {

    public PriceHistoryRepository priceHistoryRepository;

    public PriceHistoryService(PriceHistoryRepository priceHistoryRepository) {
        this.priceHistoryRepository = priceHistoryRepository;
    }

    public Optional<PriceHisotoryResponseDTO> getPriceHistoryById(Long id) {
        PriceHistory priceHistory = priceHistoryRepository.findById(id).orElseThrow();
        return Optional.of(Mapper.priceHistoryToResponseDTO(priceHistory));
    }

}

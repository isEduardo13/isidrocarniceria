package com.carniceria.isidro.isidrocarniceria.orders.details.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.carniceria.isidro.isidrocarniceria.orders.details.entity.Detail;
import com.carniceria.isidro.isidrocarniceria.orders.details.repository.DetailRepository;

@Service
public class DetailService {

    private final DetailRepository detailRepository;

    public DetailService(DetailRepository detailRepository) {
        this.detailRepository = detailRepository;
    }

    public Optional<Detail> findById(Long id) {
        return detailRepository.findById(id);
    }
    
}

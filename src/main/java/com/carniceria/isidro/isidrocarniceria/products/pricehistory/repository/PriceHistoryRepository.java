package com.carniceria.isidro.isidrocarniceria.products.pricehistory.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.carniceria.isidro.isidrocarniceria.products.pricehistory.entity.PriceHistory;

@Repository
public interface PriceHistoryRepository extends  JpaRepository<PriceHistory, Long> {

    @Override
    @Query("SELECT ph FROM PriceHistory ph WHERE ph.id = :id")
    Optional<PriceHistory> findById(Long id);

}

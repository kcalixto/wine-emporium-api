package com.wineemporium.repository;

import com.wineemporium.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {
}

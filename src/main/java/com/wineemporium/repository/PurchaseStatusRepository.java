package com.wineemporium.repository;

import com.wineemporium.entity.PurchaseStatus;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PurchaseStatusRepository extends JpaRepository<PurchaseStatus, Integer> {
}

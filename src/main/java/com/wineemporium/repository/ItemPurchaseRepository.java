package com.wineemporium.repository;

import com.wineemporium.entity.ItemPurchase;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemPurchaseRepository extends JpaRepository<ItemPurchase, Integer> {
}

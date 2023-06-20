package com.wineemporium.repository;

import com.wineemporium.entity.Wine;
import org.springframework.data.jpa.repository.JpaRepository;


public interface WineRepository extends JpaRepository<Wine, Integer> {
}

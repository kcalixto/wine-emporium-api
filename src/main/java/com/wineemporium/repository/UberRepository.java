package com.wineemporium.repository;

import com.wineemporium.entity.Uber;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UberRepository extends JpaRepository<Uber, Integer> {
}

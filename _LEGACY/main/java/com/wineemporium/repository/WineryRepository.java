package com.wineemporium.repository;

import com.wineemporium.entity.Winery;
import org.springframework.data.jpa.repository.JpaRepository;


public interface WineryRepository extends JpaRepository<Winery, String> {
}

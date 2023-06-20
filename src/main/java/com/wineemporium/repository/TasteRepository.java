package com.wineemporium.repository;

import com.wineemporium.entity.Taste;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TasteRepository extends JpaRepository<Taste, String> {
}

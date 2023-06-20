package com.wineemporium.repository;

import com.wineemporium.entity.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RatingsRepository extends JpaRepository<Ratings, Integer> {
}

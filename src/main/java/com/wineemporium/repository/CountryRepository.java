package com.wineemporium.repository;

import com.wineemporium.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CountryRepository extends JpaRepository<Country, String> {
}

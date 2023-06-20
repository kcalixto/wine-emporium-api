package com.wineemporium.repository;

import com.wineemporium.entity.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserAddressRepository extends JpaRepository<UserAddress, Integer> {
}

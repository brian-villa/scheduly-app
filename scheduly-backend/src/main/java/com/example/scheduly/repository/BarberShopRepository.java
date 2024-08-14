package com.example.scheduly.repository;

import com.example.scheduly.entity.BarberShopEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BarberShopRepository extends JpaRepository<BarberShopEntity, UUID> {
}

package com.example.scheduly.repository;

import com.example.scheduly.entity.BarberServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BarberServiceRepository extends JpaRepository<BarberServiceEntity, UUID > {
}

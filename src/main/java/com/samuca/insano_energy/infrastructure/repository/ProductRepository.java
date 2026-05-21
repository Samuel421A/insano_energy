package com.samuca.insano_energy.infrastructure.repository;

import com.samuca.insano_energy.infrastructure.entity.Product;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(Long id);
    void deleteById(@NonNull Long id);
}
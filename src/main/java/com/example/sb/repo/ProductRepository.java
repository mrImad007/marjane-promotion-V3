package com.example.sb.repo;

import com.example.sb.model.Entities.Produits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Produits,Long> {
    Optional<Produits> findById(Long id);
}

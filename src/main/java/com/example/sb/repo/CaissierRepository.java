package com.example.sb.repo;

import com.example.sb.model.Entities.Caissier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CaissierRepository extends JpaRepository<Caissier,Long> {
    Optional<Caissier> findById(Long id);
}

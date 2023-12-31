package com.example.sb.repo;

import com.example.sb.model.Entities.Admin;
import com.example.sb.model.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
    Optional<Client> findById(Long id);
    public Optional<Client> findByEmail(String email);
}

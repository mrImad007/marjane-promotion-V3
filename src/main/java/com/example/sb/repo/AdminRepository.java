package com.example.sb.repo;

import com.example.sb.model.Entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
     Optional<Admin> findByEmail(String email);

}

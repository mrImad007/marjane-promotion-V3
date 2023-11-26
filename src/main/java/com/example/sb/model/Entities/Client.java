package com.example.sb.model.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code_fidelity;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private Long solde;

    @ManyToOne
    @JoinColumn(name = "id_caissier")
    private Caissier caissier;

}

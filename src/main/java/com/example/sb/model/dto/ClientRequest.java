package com.example.sb.model.dto;

import com.example.sb.model.Entities.Admin;
import com.example.sb.model.Entities.Caissier;
import com.example.sb.model.Entities.Client;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.event.FocusEvent;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientRequest {
    @Email(message = "Email was not provided")
    @NotEmpty(message = "email must be present")
    @Column(unique = true)
    private String email;
    private String password;
    private String first_name;
    private String last_name;
    private Long caissier_id;
    private Long solde;

    public Client toModel() {
        Caissier caissier = Caissier.builder().id(caissier_id).build();

        return Client.builder()
                .email(this.email)
                .password(this.password)
                .first_name(this.first_name)
                .last_name(this.last_name)
                .solde(this.solde)
                .caissier(caissier)
                .build();
    }
}

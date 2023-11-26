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
    private Long caissier_id;

    public Client toModel() {
        Caissier caissier = Caissier.builder().id(caissier_id).build();

        return Client.builder()
                .email(this.email)
                .password(this.password)
                .caissier(caissier)
                .build();
    }
}

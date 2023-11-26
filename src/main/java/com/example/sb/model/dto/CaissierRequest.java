package com.example.sb.model.dto;

import com.example.sb.model.Entities.Admin;
import com.example.sb.model.Entities.Caissier;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CaissierRequest {

    @Email(message = "Email was not provided")
    @NotEmpty(message = "email must be present")
    @Column(unique = true)
    private String email;
    private String password;

    private Long admin_id;
    public Caissier toModel(){
        Admin admin = Admin
                .builder()
                .id(admin_id)
                .build();
        return Caissier.
                builder()
                .email(this.email)
                .password(this.password)
                .admin(admin)
                .build();
    }
}

package com.example.sb.model.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CaisserDto {
    private Long id;
    @Email(message = "Email was not provided")
    @NotEmpty(message = "email must be present")
    @Column(unique = true)
    private String email;
    @NotBlank(message = "Rayon name cannot be blank")
    @Size(max = 255, message = "Rayon name cannot exceed 255 characters")
    private String first_name;
    @NotBlank(message = "Rayon name cannot be blank")
    @Size(max = 255, message = "Rayon name cannot exceed 255 characters")
    private String last_name;
    private String password;
}

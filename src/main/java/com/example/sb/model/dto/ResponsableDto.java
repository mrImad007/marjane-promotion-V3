package com.example.sb.model.dto;

import com.example.sb.model.Entities.Admin;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponsableDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Admin admin;
    private RayonDto rayon;

}

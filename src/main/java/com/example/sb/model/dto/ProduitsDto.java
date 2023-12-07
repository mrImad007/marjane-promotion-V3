package com.example.sb.model.dto;

import com.example.sb.model.Entities.Categories;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProduitsDto {

    private Long id;
    @NotBlank(message = "Name name cannot be blank")
    @Size(max = 255, message = "Product name cannot exceed 255 characters")
    private String name;
    private Long price;
    private Long quantity ;
    @NotNull(message = "Category cannot be null")
    private Categories categorie;

}

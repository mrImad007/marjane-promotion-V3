package com.example.sb.model.dto;

        import com.example.sb.model.Enum.Statut;
        import com.example.sb.model.Entities.*;
        import jakarta.persistence.Column;
        import jakarta.validation.constraints.Email;
        import jakarta.validation.constraints.NotEmpty;
        import lombok.AllArgsConstructor;
        import lombok.Builder;
        import lombok.Data;
        import lombok.NoArgsConstructor;

        import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PromotionRequest {
    @Email(message = "Email was not provided")
    @NotEmpty(message = "email must be present")
    @Column(unique = true)
    private LocalDate datepromo;

    private Long id;

    private Statut statut;

    private Integer quantity;
    private Integer reduction;

    private Long responsable_id;

    private Long categorie_id;

    private Long produit_id;


    public Promotions toModel(){
        Responsable  responsable1= Responsable
                                  .builder()
                                  .id(responsable_id)
                                  .build();
        Categories categorie1 = Categories
                                .builder()
                                .id(categorie_id)
                                .build();
        Produits produits1 = Produits
                            .builder()
                            .id(produit_id)
                            .build();
        return Promotions.
                builder()
                .datepromo(this.datepromo)
                .statut(this.statut)
                .quantity(this.quantity)
                .reduction(this.reduction)
                .responsable(responsable1)
                .categorie(categorie1)
                .produit(produits1)
                .build();
    }

}

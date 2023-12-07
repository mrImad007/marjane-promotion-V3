
package com.example.sb.resource;

        import com.example.sb.model.Enum.Statut;
        import com.example.sb.model.dto.PromotionRequest;
        import com.example.sb.model.dto.PromotionsDto;

        import com.example.sb.service.Impl.PromotionManagerApplicationImpl;
        import jakarta.validation.Valid;
        import lombok.AllArgsConstructor;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v3/promotions")
@CrossOrigin(origins = "http://localhost:4200")
public class PromotionResource extends Resource<PromotionsDto, PromotionRequest,Long>{
    @Autowired
    public void setService(
            PromotionManagerApplicationImpl service
    ) {
        this.service = service;
    }
    private final PromotionManagerApplicationImpl promotionService;

    @GetMapping("{promotion_id}")
    public boolean findResource(@PathVariable("id") Long id) {
        return promotionService.isExist(id);
    }

    @PostMapping("/add_promotion")
    public PromotionsDto add_promotion(@RequestBody PromotionRequest promotionRequest) {
        try {
            PromotionsDto createdPromotion = promotionService.save(promotionRequest);
            return createdPromotion;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to add promotion");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PromotionsDto> update(@PathVariable("id") final Long id, @Valid @RequestBody final PromotionRequest promotionRequest) {
        if (!service.isExist(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        System.out.println("inside update method");
        var updatedDto = promotionService.updatePromo(id, promotionRequest);
        return new ResponseEntity<>(updatedDto, HttpStatus.OK);
    }


}


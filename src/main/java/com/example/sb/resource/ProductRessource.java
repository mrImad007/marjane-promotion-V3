package com.example.sb.resource;

import com.example.sb.model.dto.ProduitsDto;
import com.example.sb.service.Impl.ProductManagerApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v3/products")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductRessource {
    private final ProductManagerApplication productService;

    public ProductRessource(ProductManagerApplication productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProduitsDto> getAll(){
        return productService.getAll();
    }
}

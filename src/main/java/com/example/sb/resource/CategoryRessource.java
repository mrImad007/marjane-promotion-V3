package com.example.sb.resource;

import com.example.sb.model.dto.CategoriesDto;
import com.example.sb.service.Impl.CategoryManagerApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v3/categories")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryRessource {
    private final CategoryManagerApplication categoryService;
    public CategoryRessource(CategoryManagerApplication categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<CategoriesDto> getAll(){
        return categoryService.getall();
    }

}

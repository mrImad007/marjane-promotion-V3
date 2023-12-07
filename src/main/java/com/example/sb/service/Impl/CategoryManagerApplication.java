package com.example.sb.service.Impl;

import com.example.sb.model.Entities.Categories;
import com.example.sb.model.dto.CategoriesDto;
import com.example.sb.model.mappers.Mapper;
import com.example.sb.repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryManagerApplication {
    private final CategoryRepository categoryRepository;
    private final Mapper<Categories, CategoriesDto> categoryMapper;

    public CategoryManagerApplication(CategoryRepository categoryRepository,@Qualifier("categoriesMapper") Mapper<Categories, CategoriesDto> categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public List<CategoriesDto> getall(){
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::mapTo)
                .collect(Collectors.toList());
    }
}

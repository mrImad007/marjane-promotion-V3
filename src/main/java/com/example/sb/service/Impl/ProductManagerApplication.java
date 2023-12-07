package com.example.sb.service.Impl;

import com.example.sb.model.Entities.Produits;
import com.example.sb.model.dto.ClientDto;
import com.example.sb.model.dto.ProduitsDto;
import com.example.sb.model.mappers.Mapper;
import com.example.sb.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductManagerApplication {
    private final ProductRepository productRepository;
    private final Mapper<Produits, ProduitsDto> productMapper;
    @Autowired
    public ProductManagerApplication(ProductRepository productRepository,@Qualifier("produitsMapper") Mapper<Produits, ProduitsDto> productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public List<ProduitsDto> getAll() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::mapTo)
                .collect(Collectors.toList());
    }

}

package com.example.sb.service.Impl;

import com.example.sb.model.Entities.Caissier;
import com.example.sb.model.dto.CaisserDto;
import com.example.sb.model.mappers.Mapper;
import com.example.sb.repo.CaissierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CaisserManagerApplication {
    private final CaissierRepository caissierRepository;
    private final Mapper<Caissier, CaisserDto> cassierMapper;

    @Autowired
    public CaisserManagerApplication(CaissierRepository caissierRepository,  @Qualifier("caissierMapper") Mapper<Caissier, CaisserDto> cassierMapper) {
        this.caissierRepository = caissierRepository;
        this.cassierMapper = cassierMapper;
    }

    public List<CaisserDto> getAll() {
        return caissierRepository.findAll()
                .stream()
                .map(cassierMapper::mapTo)
                .collect(Collectors.toList());
    }

}

package com.example.sb.model.mappers.Impl;

import com.example.sb.model.Entities.Caissier;
import com.example.sb.model.dto.CaisserDto;
import com.example.sb.model.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CaissierMapper implements Mapper<Caissier, CaisserDto> {
    private final ModelMapper modelMapper;

    public CaissierMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CaisserDto mapTo(Caissier caissier) {
        return modelMapper.map(caissier, CaisserDto.class);
    }

    @Override
    public Caissier mapFrom(CaisserDto caisserDto) {
        return modelMapper.map(caisserDto, Caissier.class);
    }
}

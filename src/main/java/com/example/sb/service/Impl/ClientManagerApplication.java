package com.example.sb.service.Impl;

import com.example.sb.model.Entities.Client;
import com.example.sb.model.dto.CaisserDto;
import com.example.sb.model.dto.ClientDto;
import com.example.sb.model.mappers.Mapper;
import com.example.sb.repo.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientManagerApplication{
    private final ClientRepository clientRepository;
    private final Mapper<Client, ClientDto> clientMapper;
    @Autowired
    public ClientManagerApplication(ClientRepository clientRepository, @Qualifier("clientMapper") Mapper<Client, ClientDto> clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    public List<ClientDto> getAll() {
        return clientRepository.findAll()
                .stream()
                .map(clientMapper::mapTo)
                .collect(Collectors.toList());
    }
}

package com.example.sb.service.Impl;

import com.example.sb.model.Entities.Admin;
import com.example.sb.model.Entities.Client;
import com.example.sb.model.dto.AdminDto;
import com.example.sb.model.dto.ClientDto;
import com.example.sb.model.dto.ClientRequest;
import com.example.sb.model.mappers.Mapper;
import com.example.sb.repo.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientManagerApplication{
    private final ClientRepository clientRepository;
    private final Mapper<Client, ClientDto> clientMapper;
    private final JavaMailSender javaMailSender;
    @Autowired
    public ClientManagerApplication(ClientRepository clientRepository, @Qualifier("clientMapper") Mapper<Client, ClientDto> clientMapper, JavaMailSender javaMailSender) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
        this.javaMailSender = javaMailSender;
    }

    public List<ClientDto> getAll() {
        return clientRepository.findAll()
                .stream()
                .map(clientMapper::mapTo)
                .collect(Collectors.toList());
    }
    public ClientDto save(ClientRequest clientRequest) {
        var caissierEntity = clientRequest.toModel();
        var createdResponsable = clientMapper.mapTo(clientRepository.save(caissierEntity));
        System.out.println(getCLientByEmail(clientRequest.getEmail()));
        return createdResponsable;
    }

    private void sendPasswordToEmail(String clientEmail, String password) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(clientEmail);
        message.setSubject("Marjane Code de Fidelité ");
        message.setText("Votre Code de Fidelité: " + password);
        javaMailSender.send(message);
    }

    public ClientDto getCLientByEmail(String email) {
        Optional<Client> adminOptional  = clientRepository.findByEmail(email);
        if (adminOptional.isPresent()) {
            Client clientEntity = adminOptional.get();
            return clientMapper.mapTo(clientEntity);
        } else {
            return null;
        }
    }
}

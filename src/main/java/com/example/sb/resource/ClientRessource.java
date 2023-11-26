package com.example.sb.resource;

import com.example.sb.model.dto.ClientDto;
import com.example.sb.service.Impl.ClientManagerApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v2/clients")
public class ClientRessource {
    private final ClientManagerApplication clientManager;

    public ClientRessource(ClientManagerApplication clientManager) {
        this.clientManager = clientManager;
    }

    @GetMapping
    public List<ClientDto> getAll(){
        return clientManager.getAll();
    }
}

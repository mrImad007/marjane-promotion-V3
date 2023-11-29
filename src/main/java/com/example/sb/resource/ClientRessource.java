package com.example.sb.resource;

import com.example.sb.model.dto.ClientDto;
import com.example.sb.model.dto.ClientRequest;
import com.example.sb.service.Impl.ClientManagerApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v3/clients")
public class ClientRessource {
    private final ClientManagerApplication clientManager;

    public ClientRessource(ClientManagerApplication clientManager) {
        this.clientManager = clientManager;
    }

    @GetMapping
    public List<ClientDto> getAll(){
        return clientManager.getAll();
    }

    @PostMapping
    public void save(@RequestBody ClientRequest clientRequest){
        clientManager.save(clientRequest);
    }
}

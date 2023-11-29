package com.example.sb.Observer;

import com.example.sb.model.dto.ClientDto;
import org.springframework.context.ApplicationEvent;

public class ClientEvent extends ApplicationEvent {
    private final ClientDto clientDto;
    public ClientEvent(Object source, ClientDto clientDto) {
        super(source);
        this.clientDto = clientDto;
    }
    public ClientDto getClientDto(){
        return clientDto;
    }
}

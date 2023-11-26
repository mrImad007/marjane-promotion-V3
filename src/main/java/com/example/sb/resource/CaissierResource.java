package com.example.sb.resource;

import com.example.sb.model.dto.CaisserDto;
import com.example.sb.service.Impl.CaisserManagerApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("api/v2/caissier")
public class CaissierResource {
    private final CaisserManagerApplication caisserManager ;

    public CaissierResource(CaisserManagerApplication caisserManager) {
        this.caisserManager = caisserManager;
    }

    @GetMapping
    public List<CaisserDto> getAll(){
        return caisserManager.getAll();
    }
}

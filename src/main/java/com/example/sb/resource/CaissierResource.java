package com.example.sb.resource;

import com.example.sb.model.dto.CaisserDto;
import com.example.sb.model.dto.CaissierRequest;
import com.example.sb.service.Impl.CaisserManagerApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v3/cashiers")
@CrossOrigin(origins = "http://localhost:4200")
public class CaissierResource {
    private final CaisserManagerApplication caisserManager ;

    public CaissierResource(CaisserManagerApplication caisserManager) {
        this.caisserManager = caisserManager;
    }

    @GetMapping
    public List<CaisserDto> getAll(){
        return caisserManager.getAll();
    }

    @PostMapping()
    public void save(@RequestBody CaissierRequest caissierRequest){
        caisserManager.save(caissierRequest);
    }
}

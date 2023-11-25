package com.example.sb.resource;

import jakarta.ws.rs.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v2/caissier")
public class CaissierResource {
    @GetMapping
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }
}

package com.backend.rainparksolutions.controller;

import com.backend.rainparksolutions.model.Employer;
import com.backend.rainparksolutions.service.EmployerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@RestController
@Produces(MediaType.APPLICATION_JSON)
@RequestMapping(path = "/api/employer")
public class EmployerController {

    private final EmployerService employerService;

    @PostMapping(" ")
    public ResponseEntity<Map<String, Boolean>> create(@Valid @RequestBody Employer employer) {
        employerService.create(employer);
        Map<String, Boolean> map = new HashMap<>();
        map.put("success", true);
        return ResponseEntity.status(HttpStatus.OK).body(map);
    }
}

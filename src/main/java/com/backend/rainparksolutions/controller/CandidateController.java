package com.backend.rainparksolutions.controller;

import com.backend.rainparksolutions.model.Candidate;
import com.backend.rainparksolutions.service.CandidateService;
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
@RequestMapping(path = "/api/candidate")
public class CandidateController {

    private final CandidateService candidateService;

    @PostMapping(" ")
    public ResponseEntity<Map<String, Boolean>> create(@Valid @RequestBody Candidate candidate) {
        candidateService.create(candidate);
        Map<String, Boolean> map = new HashMap<>();
        map.put("success", true);
        return ResponseEntity.status(HttpStatus.OK).body(map);
    }
}

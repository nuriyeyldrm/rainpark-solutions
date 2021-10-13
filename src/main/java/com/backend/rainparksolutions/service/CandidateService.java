package com.backend.rainparksolutions.service;

import com.backend.rainparksolutions.model.Candidate;
import com.backend.rainparksolutions.repository.CandidateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CandidateService {

    private final CandidateRepository candidateRepository;

    public void create(Candidate candidate) {
        candidateRepository.save(candidate);
    }
}

package com.backend.rainparksolutions.service;

import com.backend.rainparksolutions.exception.BadRequestException;
import com.backend.rainparksolutions.exception.ConflictException;
import com.backend.rainparksolutions.model.Candidate;
import com.backend.rainparksolutions.repository.CandidateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CandidateService {

    private final CandidateRepository candidateRepository;

    public void create(Candidate candidate) throws BadRequestException {
        boolean emailExists = candidateRepository.findByEmail(candidate.getEmail()).isPresent();

        if (emailExists) {
            throw new ConflictException("email already taken");
        }

        candidateRepository.save(candidate);
    }
}

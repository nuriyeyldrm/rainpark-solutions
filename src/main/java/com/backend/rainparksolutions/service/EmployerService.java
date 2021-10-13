package com.backend.rainparksolutions.service;

import com.backend.rainparksolutions.model.Employer;
import com.backend.rainparksolutions.repository.EmployerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EmployerService {

    private final EmployerRepository employerRepository;

    public void create(Employer employer) {
        employerRepository.save(employer);
    }
}

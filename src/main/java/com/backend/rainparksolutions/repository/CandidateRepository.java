package com.backend.rainparksolutions.repository;

import com.backend.rainparksolutions.exception.ResourceNotFoundException;
import com.backend.rainparksolutions.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    Optional<Candidate> findByEmail(String email) throws ResourceNotFoundException;
}

package com.backend.rainparksolutions.repository;

import com.backend.rainparksolutions.model.FileDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface FileRepository extends JpaRepository<FileDB, String> {
}

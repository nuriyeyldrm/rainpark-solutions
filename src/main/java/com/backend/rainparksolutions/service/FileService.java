package com.backend.rainparksolutions.service;

import com.backend.rainparksolutions.model.FileDB;
import com.backend.rainparksolutions.repository.FileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class FileService {

    private final FileRepository fileRepository;

    public void store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        FileDB fileDB = new FileDB(fileName, file.getContentType(), file.getBytes());

        fileRepository.save(fileDB);
    }

    public FileDB getFile(String id) {
        return fileRepository.findById(id).get();
    }

    public Stream<FileDB> getAllFiles() {
        return fileRepository.findAll().stream();
    }
}

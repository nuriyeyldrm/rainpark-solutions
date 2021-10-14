package com.backend.rainparksolutions.controller;

import com.backend.rainparksolutions.dao.FileDAO;
import com.backend.rainparksolutions.model.FileDB;
import com.backend.rainparksolutions.service.FileService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@Produces(MediaType.APPLICATION_JSON)
@CrossOrigin("http://localhost:8081")
@RequestMapping(path = "/api")
public class FileController {

    private final FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<Map<String, String>> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            fileService.store(file);
            Map<String, String> map = new HashMap<>();
            map.put("message", "Uploaded the file successfully: " + file.getOriginalFilename());
            return ResponseEntity.status(HttpStatus.OK).body(map);

        } catch (Exception e) {

            Map<String, String> map = new HashMap<>();
            map.put("message", "Could not upload the file: " + file.getOriginalFilename() + "!");
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(map);
        }
    }

    @GetMapping("/files")
    public ResponseEntity<List<FileDAO>> getAllFiles() {
        List<FileDAO> files = fileService.getAllFiles().map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/api/files/")
                    .path(dbFile.getId())
                    .toUriString();

            return new FileDAO(dbFile.getName(), fileDownloadUri, dbFile.getType(), dbFile.getData().length);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @GetMapping("/files/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable String id) {
        FileDB fileDB = fileService.getFile(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\\\""
                        + fileDB.getName() + "\"")
                .body(fileDB.getData());
    }
}

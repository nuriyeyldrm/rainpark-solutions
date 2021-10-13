package com.backend.rainparksolutions.dao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileDAO {

    private String name;
    private String url;
    private String type;
    private long size;
    private String message;

    public FileDAO(String name, String url, String type, long size) {
        this.name = name;
        this.url = url;
        this.type = type;
        this.size = size;
    }

    public FileDAO(String message) {
        this.message = message;
    }
}

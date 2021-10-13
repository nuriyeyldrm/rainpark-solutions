package com.backend.rainparksolutions.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "files")
public class FileDB {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id; // automatically generated as UUID

    private String name; // name of the file

    private String type; // mime type

    @Lob // datatype for storing large object data
    private byte[] data; // array of bytes, map to a BLOB (BLOB is for storing binary data)

    public FileDB(String name, String type, byte[] data) {
        this.name = name;
        this.type = type;
        this.data = data;
    }
}

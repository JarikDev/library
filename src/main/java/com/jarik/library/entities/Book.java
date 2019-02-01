package com.jarik.library.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Arrays;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @NotBlank(message = "Book name is mandatory")
    private String bookName;

    @NotBlank(message = "At least small book description is mandatory")
    private String description;

    @NotBlank(message = "Filetype is mandatory")
    private String fileType;


    // blob
    @Lob
    @Column
    private byte[] data;
    public byte[] getData() {return data; }
    public void setData(byte[] data) {this.data = data; }

    // standard constructors / setters / getters / toString
    public Book() {}
    public Book(@NotBlank(message = "Name is mandatory") String bookName,
                @NotBlank(message = "At least small book description is mandatory") String fileType,
                @NotBlank(message = "File is mandatory") byte[] data) {
        this.bookName = bookName;
        this.description = fileType;
        this.data = data;
    }

    public String getId() {return id;  }
    public void setId(String id) {  this.id = id; }
    public String getBookName() { return bookName;  }
    public void setBookName(String bookName) { this.bookName = bookName; }
    public String getDescription() { return description;}
    public void setDescription(String description) { this.description = description; }
    public String getFileType() { return fileType; }
    public void setFileType(String fileType) { this.fileType = fileType; }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", description='" + description + '\'' +
                ", fileType='" + fileType + '\'' +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}


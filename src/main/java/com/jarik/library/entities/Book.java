package com.jarik.library.entities;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Book name is mandatory")
    private String bookName;

    @NotBlank(message = "At least small book description is mandatory")
    private String description;

    // Upload files.
    @Lob
    @Column
    private MultipartFile[] bookFile;

    public MultipartFile[] getBookFile() { return bookFile; }
    public void setBookFile(MultipartFile[] bookFile) { this.bookFile = bookFile; }



    // standard constructors / setters / getters / toString
    public Book() {}

    public Book(@NotBlank(message = "Book name is mandatory") String bookName,
                @NotBlank(message = "At least small book description is mandatory") String description,
                MultipartFile[] bookFile) {
        this.bookName = bookName;
        this.description = description;
        this.bookFile = bookFile;
    }

    public long getId() {return id;  }
    public void setId(long id) {  this.id = id; }
    public String getBookName() { return bookName;  }
    public void setBookName(String bookName) { this.bookName = bookName; }
    public String getDescription() { return description;}
    public void setDescription(String description) { this.description = description; }
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}


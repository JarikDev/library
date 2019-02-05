package com.jarik.library.entities;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Arrays;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookId;

    @NotBlank(message = "Book name is mandatory")
    private String bookName;

    @NotBlank(message = "At least small book bookDescription is mandatory")
    private String bookDescription;

    // Upload files.
    @Lob
    @Column(name = "bookFile", columnDefinition="BLOB")
    private byte[] bookData;

    // standard constructors / setters / getters / toString
    public Book() {}

    public Book(@NotBlank(message = "Book name is mandatory") String bookName,
                @NotBlank(message = "At least small book bookDescription is mandatory") String bookDescription,
                byte[] bookData) {
        this.bookName = bookName;
        this.bookDescription = bookDescription;
        this.bookData = bookData;
    }

    public byte[] getBookData() { return bookData; }
    public void setBookData(byte[] bookData) { this.bookData = bookData; }
    public long getBookId() {return bookId;  }
    public void setBookId(long bookId) {  this.bookId = bookId; }
    public String getBookName() { return bookName;  }
    public void setBookName(String bookName) { this.bookName = bookName; }
    public String getBookDescription() { return bookDescription;}
    public void setBookDescription(String bookDescription) { this.bookDescription = bookDescription; }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookDescription='" + bookDescription + '\'' +
                ", bookData=" + Arrays.toString(bookData) +
                '}';
    }
}


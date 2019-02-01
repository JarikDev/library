package com.jarik.library.service;
import com.jarik.library.exception.FileStorageException;
import com.jarik.library.exception.MyFileNotFoundException;


import com.jarik.library.entities.Book;
import com.jarik.library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Service
public class StorageService {
    @Autowired
    private BookRepository bookRepository;

    public BookRepository getBookRepository() { return bookRepository; }
    public void setBookRepository(BookRepository bookRepository) { this.bookRepository = bookRepository; }

    public Book storeBook(MultipartFile bookFile) {
        // Normalize file name
        String bookName = StringUtils.cleanPath(bookFile.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(bookName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + bookName);
            }

            Book book = new Book(bookName, bookFile.getContentType(), bookFile.getBytes());

            return bookRepository.save(book);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + bookName + ". Please try again!", ex);
        }
    }

    public Book getBook(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + id));
    }
}

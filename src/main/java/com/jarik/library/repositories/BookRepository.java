package com.jarik.library.repositories;

import com.jarik.library.entities.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {List<Book> findByBookName(String bookName);}

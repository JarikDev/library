package com.jarik.library.controllers;

import com.jarik.library.controllers.payload.UploadBookResponse;
import com.jarik.library.entities.Book;
import com.jarik.library.repositories.BookRepository;
import com.jarik.library.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private StorageService storageService=new StorageService();
    BookRepository bookRepository=storageService.getBookRepository();

    public BookController() { }
    public BookController(BookRepository bookRepository) { this.bookRepository = bookRepository; }

    @GetMapping("/signup")
    public String showSignUpForm(Book book) {
        return "add-book";
    }



    @PostMapping("/addbook")
    public String addBook(@RequestParam("books") MultipartFile  book ,Model model) {

        Book bookFile= storageService.storeBook(book);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(bookFile.getId())
                .toUriString();

          new UploadBookResponse(bookFile.getBookName(), fileDownloadUri,
                book.getContentType(), book.getSize());


        model.addAttribute("books", bookRepository.findAll());
        return "index";
    }

  /*  @PostMapping("/uploadMultipleFiles")
    public String uploadMultipleFiles(@RequestParam("files") MultipartFile[] files ) {
          Arrays.asList(files)
                .stream()
                .map(file -> addBook(file))
                .collect(Collectors.toList());
        return "index";
    }
*/




    //commit before indian guide
    /*@PostMapping("/addbook")
    public String addBook(@RequestParam("book") MultipartFile book, BindingResult result, Model model) {
        Book bookFile=storageService.storeBook(book);

        String bookDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(bookFile.getId())
                .toUriString();

          new UploadBookResponse (bookFile.getBookName(), bookDownloadUri,
                book.getContentType(), book.getSize());

        if (result.hasErrors()) {
            return "add-book";
        }
       bookRepository.save(book);
       model.addAttribute("books", bookRepository.findAll());
        return "index";
    }


    @PostMapping("/addbookmultipart")
    public String uploadMultipleFiles(@RequestParam("books") MultipartFile[] books,
                                                       BindingResult result, Model model) {
          Arrays.asList(books,result,model)
                .stream()
                .map(book -> addBook(book))
                .collect(Collectors.toList());

        if (result.hasErrors()) {
            return "add-book";
        }
//       bookRepository.save(book);
        model.addAttribute("books", bookRepository.findAll());
        return "index";

    }




    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));

        model.addAttribute("book", book);
        return "update-book";
    }

    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable("id") String id, @Valid Book book,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            book.setId(id);
            return "update-book";
        }

        bookRepository.save(book);
        model.addAttribute("books", bookRepository.findAll());
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") long id, Model model) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        bookRepository.delete(book);
        model.addAttribute("books", bookRepository.findAll());
        return "index";
    }*/


    //Old version, stored for heirs
   /* private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) { this.bookRepository = bookRepository; }

    @GetMapping("/signup")
    public String showSignUpForm(Book book) {
        return "add-book";
    }

    @PostMapping("/addbook")
    public String addBook(@Valid Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-book";
        }

        bookRepository.save(book);
        model.addAttribute("books", bookRepository.findAll());
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));

        model.addAttribute("book", book);
        return "update-book";
    }

    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable("id") long id, @Valid Book book,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            book.setId(id);
            return "update-book";
        }

        bookRepository.save(book);
        model.addAttribute("books", bookRepository.findAll());
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") long id, Model model) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        bookRepository.delete(book);
        model.addAttribute("books", bookRepository.findAll());
        return "index";
    }*/
}

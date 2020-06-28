package com.mgmt.librarymgmt.Controller;

import com.mgmt.librarymgmt.DataAccessLayer.Book;
import com.mgmt.librarymgmt.Exception.BookNotFoundException;
import com.mgmt.librarymgmt.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/books")
    List<Book> findAll() {
        try {
            return bookService.findAllBooks();
        } catch (BookNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Books Found", e);
        }
    }

    @PostMapping("/book")
    @ResponseStatus(HttpStatus.CREATED)
    Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping(value = "/searchBooksByAuthor")
    public List<Book> getBooksByAuthor(@RequestParam(value = "author") String author) {
        return bookService.getBooksByAuthor(author);
    }

    @GetMapping(value = "/searchBooksBySubject")
    public List<Book> getBooksBySubject(@RequestParam(value = "subject") String subject) {
        return bookService.getBooksBySubject(subject);
    }
}

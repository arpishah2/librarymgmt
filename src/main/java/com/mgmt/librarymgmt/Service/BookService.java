package com.mgmt.librarymgmt.Service;

import com.mgmt.librarymgmt.DataAccessLayer.Book;
import com.mgmt.librarymgmt.DataAccessLayer.BookRepository;
import com.mgmt.librarymgmt.Exception.BookNotFoundException;
import com.mgmt.librarymgmt.Util.BookValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class BookService {

    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Autowired
    BookRepository bookRepository;

    BookValidator validator = new BookValidator();


    public List<Book> findAllBooks() throws BookNotFoundException {
        LOGGER.info("FindAll Books Called");

        List<Book> books = bookRepository.findAll();
        if (books.size() == 0) {
            LOGGER.severe("No book was found!");
            throw new BookNotFoundException();
        }
        return books;
    }

    public Book addBook(Book book) {
        LOGGER.info("I am here");
        if (validator.isBookValid(book)) {
            return bookRepository.save(book);
        } else {
            LOGGER.severe("Invalid Book: " + book);
            return null;
        }
    }

    public List<Book> getBooksByAuthor(String author) {
        List<Book> booksByAuthor = bookRepository.findByAuthor(author);
        if (booksByAuthor.size() == 0) {
            LOGGER.severe("No books available with authorName" + author);
        }
        return booksByAuthor;
    }

    public List<Book> getBooksBySubject(String subject) {
        List<Book> booksBySubject = bookRepository.findBySubject(subject);
        if (booksBySubject.size() == 0) {
            LOGGER.severe("No books available with subject " + subject);
        }
        return booksBySubject;
    }
}

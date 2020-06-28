package com.mgmt.librarymgmt.Controller;

import com.mgmt.librarymgmt.DataAccessLayer.IssuedBooks;
import com.mgmt.librarymgmt.Service.IssuedBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class IssuedBooksController {

    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Autowired
    IssuedBooksService issuedBooksService;

    @GetMapping("/issuedBooks")
    public List<IssuedBooks> getIssuedBooks() {
        return issuedBooksService.getIssuedBooks();
    }

    @PostMapping("/issueBook")
    @ResponseStatus(HttpStatus.CREATED)
    public IssuedBooks issueABook(@RequestBody IssuedBooks issuedBook) {

        try {
            return issuedBooksService.issueABook(issuedBook);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/issuedBooksByUser")
    public List<IssuedBooks> getIssuedBooksByUser(@RequestParam(value = "userId") int userId){
        return issuedBooksService.getIssuedBooksByUser(userId);
    }
}

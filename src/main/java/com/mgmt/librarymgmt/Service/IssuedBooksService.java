package com.mgmt.librarymgmt.Service;

import com.mgmt.librarymgmt.DataAccessLayer.IssuedBooks;
import com.mgmt.librarymgmt.DataAccessLayer.IssuedBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class IssuedBooksService {

    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Autowired
    IssuedBooksRepository issuedBooksRepository;

    public List<IssuedBooks> getIssuedBooks() {
        List<IssuedBooks> issuedBooks = issuedBooksRepository.findAll();
        if (issuedBooks.size() == 0) {
            LOGGER.info("No issued books found");
        }
        return issuedBooks;
    }

    public IssuedBooks issueABook(IssuedBooks issuedBook) {
        return issuedBooksRepository.save(issuedBook);
    }

    public List<IssuedBooks> getIssuedBooksByUser(int userId) {
        List<IssuedBooks> issuedBooksByUser = issuedBooksRepository.findByUserId(userId);
        if (issuedBooksByUser.size() == 0) {
            LOGGER.info("No issued books found for userId: " + userId);
        }
        return issuedBooksByUser;
    }
}

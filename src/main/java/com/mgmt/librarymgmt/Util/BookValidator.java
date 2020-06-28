package com.mgmt.librarymgmt.Util;

import com.mgmt.librarymgmt.DataAccessLayer.Book;
import org.springframework.util.StringUtils;

public class BookValidator {

    public boolean isBookValid(Book book) {
        return !StringUtils.isEmpty(book.getTitle());
    }

}

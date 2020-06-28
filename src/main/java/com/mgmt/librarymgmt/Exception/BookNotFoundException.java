package com.mgmt.librarymgmt.Exception;

public class BookNotFoundException extends Throwable {

    public BookNotFoundException(){
        super("Book not found");
    }

    public BookNotFoundException(int id) {
        super("Book Not Found with id: "+id);
    }
}

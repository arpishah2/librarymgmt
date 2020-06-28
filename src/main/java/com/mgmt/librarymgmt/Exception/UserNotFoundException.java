package com.mgmt.librarymgmt.Exception;

public class UserNotFoundException extends Throwable {
    public UserNotFoundException() {
        super("User Not found");
    }

    public UserNotFoundException(int id) {
        super("User Not Found with id: " + id);
    }

}

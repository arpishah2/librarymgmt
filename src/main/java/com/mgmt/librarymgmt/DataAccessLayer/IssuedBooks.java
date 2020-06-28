package com.mgmt.librarymgmt.DataAccessLayer;

import javax.persistence.*;

@Entity
public class IssuedBooks {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "userId")
    private int userId;

    @Column(name = "bookId")
    private int bookId;

    @Column(name = "status")
    private String status;

    public IssuedBooks() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

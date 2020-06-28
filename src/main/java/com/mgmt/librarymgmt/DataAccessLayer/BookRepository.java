package com.mgmt.librarymgmt.DataAccessLayer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    public List<Book> findByAuthor(String author);

    public List<Book> findBySubject(String subject);

}

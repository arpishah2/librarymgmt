package com.mgmt.librarymgmt.DataAccessLayer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IssuedBooksRepository extends JpaRepository<IssuedBooks, Integer> {
    List<IssuedBooks> findByUserId(int userId);
}

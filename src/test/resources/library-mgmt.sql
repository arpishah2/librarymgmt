show databases;

create database librarymgmt;
use librarymgmt;
show tables;


CREATE TABLE user (id INT PRIMARY KEY, 
name VARCHAR(20), 
email VARCHAR(20),
mobile VARCHAR(20));

select * from user; 

CREATE TABLE book (
id INT PRIMARY KEY, 
title VARCHAR(20), 
author VARCHAR(20),
subject VARCHAR(20),
isbn varchar(20));

select * from book;


CREATE TABLE issuedBooks (
id INT PRIMARY KEY, 
userId INT, 
bookId INT,
status VARCHAR(20));

select * from issuedBooks;
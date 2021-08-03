package com.summer.service;

import com.summer.pojo.Books;

import java.util.List;

public interface BookService {
    int add(Books books);
    int deleteByID(int bookID);
    int updateBook(Books books);
    Books queryBookByID(int id);
    List<Books> queryAllBooks();
}

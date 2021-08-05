package com.summer.dao;

import com.summer.pojo.Books;

import java.util.List;

public interface BookMapper {

    int add(Books books);
    int deleteByID(int bookID);
    int updateBook(Books books);
    Books queryBookByID(int id);
    List<Books> queryAllBooks();
    Books queryBookByName(String bookName);

}

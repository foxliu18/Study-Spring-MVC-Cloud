package com.summer.service;

import com.summer.dao.BookMapper;
import com.summer.pojo.Books;

import java.util.List;

public class BookServiceImpl implements BookService{

    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper){
        this.bookMapper = bookMapper;
    }

    @Override
    public int add(Books books) {
        return bookMapper.add(books);
    }

    @Override
    public int deleteByID(int bookID) {
        return bookMapper.deleteByID(bookID);
    }

    @Override
    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    @Override
    public Books queryBookByID(int id) {
        return bookMapper.queryBookByID(id);
    }

    @Override
    public List<Books> queryAllBooks() {
        return bookMapper.queryAllBooks();
    }

    @Override
    public Books queryBookByName(String bookName) {
        return bookMapper.queryBookByName(bookName);
    }
}

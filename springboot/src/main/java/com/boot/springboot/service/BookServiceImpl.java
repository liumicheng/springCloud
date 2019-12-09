package com.boot.springboot.service;

import com.boot.springboot.Dao.BookDao;
import com.boot.springboot.Entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao dao;
    @Override
    public boolean saveBook(Book book) {
        return dao.saveBook(book);
    }
}

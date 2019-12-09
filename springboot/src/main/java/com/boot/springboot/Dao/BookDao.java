package com.boot.springboot.Dao;

import com.boot.springboot.Entity.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookDao {
    boolean saveBook(Book book);
}

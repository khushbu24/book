package com.dao;


import com.entity.Book;
import com.entity.BookCategory;
import com.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDao  {

    @Autowired
    private BookRepository bookRepository;

    public Book Save(Book b){
        return bookRepository.save(b);

    }
    public List<Book> findAll(){
        return bookRepository.findAll();

    }

}

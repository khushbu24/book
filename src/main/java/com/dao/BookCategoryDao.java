package com.dao;

import com.entity.BookCategory;
import com.repository.BookCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookCategoryDao {

    @Autowired
    private BookCategoryRepository bookCategoryRepository;

    public BookCategory Save(BookCategory b){
        return bookCategoryRepository.save(b);

    }
    public List<BookCategory> findAll(){
        return bookCategoryRepository.findAll();

    }
}
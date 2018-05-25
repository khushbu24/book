package com.repository;

import com.entity.Book;
import com.entity.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookCategoryRepository extends JpaRepository<BookCategory,Integer> {

    public List<BookCategory> findByName(String name);

}

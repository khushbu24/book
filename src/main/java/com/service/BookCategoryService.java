package com.service;

import com.dao.BookCategoryDao;
import com.entity.BookCategory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookCategoryService {

    @Autowired
    private BookCategoryDao bookCategoryDao;

    public String getAllBookCategoriesByName(String name) {
        List<BookCategory> bC = bookCategoryDao.findByName(name);
        System.out.println(bC);
        return bC.toString();
    }

    public String getAllBookCategories() {
        List<BookCategory> bC = bookCategoryDao.findAll();
        System.out.println(bC);
        return bC.toString();
    }
}


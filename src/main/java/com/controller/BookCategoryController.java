package com.controller;

import com.dao.BookCategoryDao;
import com.entity.BookCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Method;
import java.util.List;

@Controller
@RequestMapping("/bookcategories")
public class BookCategoryController {

    @Autowired
    private BookCategoryDao bookCategoryDao;

    @RequestMapping(value = "/all")
    @ResponseBody
    public String getAllBookCategories() {
        //find all book categories from DB
        List<BookCategory> bC = bookCategoryDao.findAll();
        System.out.println(bC);
        return bC.toString();
    }

}

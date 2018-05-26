package com.controller;

import com.dao.BookCategoryDao;
import com.entity.BookCategory;
import com.service.BookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Method;
import java.util.List;

@Controller
@RequestMapping("/bookcategories")
public class BookCategoryController {

    @Autowired
    private BookCategoryService bookCategoryService;

    @RequestMapping(value = "/all")
    @ResponseBody
    public ResponseEntity getAllBookCategories() {
        String response=bookCategoryService.getAllBookCategories();
        return new ResponseEntity(response,HttpStatus.OK);

    }

    @RequestMapping(value = "/name")
    @ResponseBody
    public ResponseEntity getAllBookCategoriesByName(@RequestParam("name") String name) {

        String response = bookCategoryService.getAllBookCategoriesByName(name);
       return new ResponseEntity(response,HttpStatus.OK);

    }
}

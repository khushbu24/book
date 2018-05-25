package com.controller;

import com.dao.BookDao;
import com.entity.Book;
import com.entity.BookCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.transaction.Transactional;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookDao bookDao;

    @RequestMapping(value = "/all")
    @ResponseBody
    public String getAllBooks() {
        //find all books from DB
        List<Book> b = bookDao.findAll();
        System.out.println(b);
        return b.toString();
    }



}

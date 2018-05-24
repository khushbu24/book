package com.book.controller;
import com.book.dao.BookDao;
import com.book.entity.Title;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@ComponentScan
@EnableAutoConfiguration
@Controller

@RestController
@RequestMapping(path = "/title")
public class BookController {

    @Autowired
    private BookDao bookDao;
    @GetMapping(path="/isbn")
    public Map<String,Object> getBookInfo(@RequestParam Integer isbn){

        Map<String,Object> response=new HashMap<>();
        response.put("data",null);
        response.put("error",null);

        List<Title> bookList=bookDao.getBookByIsbn(isbn);

        if(bookList.size()==0){
            Map<String,Object> errorMessage=new HashMap<>();
            errorMessage.put("message","No Title Found By This ISBN");
            response.put("error",errorMessage);
            return response;
            }

            response.put("data",bookList.get(0));
        return response;

    }





}

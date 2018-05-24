package com.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.book","com.book.dao","com.book.controller","com.book.dao.ArticleDao"})
//@EnableAutoConfiguration

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

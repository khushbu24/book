package com.book.controller;

import com.book.dao.ArticleDao;
import com.book.entity.Article;
import com.book.response.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
@Controller
//@EnableJpaRepositories("ArticleDao")
@Component
public class ArticleController {

    @Autowired
    private ArticleDao articleDao;

    @GetMapping(path = "/find")

    @ResponseBody
    public ResponseEntity<GenericResponse> findArticleById(@RequestParam("id") Integer id) {
        System.out.println("request received id : " + id);

        Article a = articleDao.findArticleById(id);
        //System.out.println(a.toString());
        //System.out.println("responding");
        if (a != null) {
            return new ResponseEntity<>( new GenericResponse<Article, Object>(a, null),HttpStatus.OK);

        } else {
            return  new ResponseEntity<>(new GenericResponse<Object, Object>(null, "no error"),HttpStatus.NOT_FOUND);

        }
    }


    @GetMapping(path = "/findAll")

    @ResponseBody
    public ResponseEntity<GenericResponse> findAllArticle() {

        List<Article> list = articleDao.findAll();
        //System.out.println(a.toString());
        //System.out.println("responding");
        if (list.size() > 0) {
            return new ResponseEntity<>(new GenericResponse<List<Article>, Object>(list, null),HttpStatus.OK);

        } else {
            return new ResponseEntity<>(new GenericResponse<Object, Object>(null, "no article found"),HttpStatus.NOT_FOUND);

        }
    }


}

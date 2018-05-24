package com.book.controller;

import com.book.dao.ArticleDao;
import com.book.entity.Article;
import com.book.request.CreateArticle;
import com.book.response.GenericResponse;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

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
            return new ResponseEntity<>(new GenericResponse<Article, Object>(a, null), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(new GenericResponse<Object, Object>(null, "no error"), HttpStatus.NOT_FOUND);

        }
    }


    @GetMapping(path = "/findAll")

    @ResponseBody
    public ResponseEntity<GenericResponse> findAllArticle() {

        List<Article> list = articleDao.findAll();
        //System.out.println(a.toString());
        //System.out.println("responding");
        if (list.size() > 0) {
            return new ResponseEntity<>(new GenericResponse<List<Article>, Object>(list, null), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(new GenericResponse<Object, Object>(null, "no article found"), HttpStatus.NOT_FOUND);

        }
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<GenericResponse> createArticle(@RequestBody CreateArticle body) {

//          @RequestBody Map<String, String> body
//        String title = body.get("title");
//        String category = body.get("category");


        if (body.getTitle() == null || body.getCategory() == null) {
            return new ResponseEntity<>(new GenericResponse<Object, Object>(null, "bad request"), HttpStatus.BAD_REQUEST);

        }
        Article article = new Article();
        article.setTitle(body.getTitle());
        article.setCategory(body.getCategory());

        Article savedArticle = null;
        try {
            savedArticle = articleDao.save(article);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new GenericResponse<Article, Object>(savedArticle, "could not create"), HttpStatus.INTERNAL_SERVER_ERROR);

        }

        if (savedArticle != null) {
            return new ResponseEntity<>(new GenericResponse<Article, Object>(savedArticle, null), HttpStatus.CREATED);

        } else {
            return new ResponseEntity<>(new GenericResponse<Article, Object>(savedArticle, "could not create"), HttpStatus.CONFLICT);

        }

    }


    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<GenericResponse> updateArticle(@RequestBody CreateArticle body) {

        if (body.getTitle() == null || body.getCategory() == null) {
            return new ResponseEntity<>(new GenericResponse<Object, Object>(null, "bad request"), HttpStatus.BAD_REQUEST);

        }
        Article article = new Article();
        article.setTitle(body.getTitle());
        article.setCategory(body.getCategory());

        Article updatedArticle = null;
        try {
            updatedArticle = articleDao.update(article);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new GenericResponse<Article, Object>(updatedArticle, "could not create"), HttpStatus.INTERNAL_SERVER_ERROR);

        }

        if (updatedArticle != null) {
            return new ResponseEntity<>(new GenericResponse<Article, Object>(updatedArticle, null), HttpStatus.CREATED);

        } else {
            return new ResponseEntity<>(new GenericResponse<Article, Object>(updatedArticle, "could not create"), HttpStatus.CONFLICT);

        }

    }


    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<GenericResponse> deleteArticle(@PathVariable("id") Long id) {


        try {
            Article a = articleDao.findArticleById(id);

            articleDao.delete(a);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new GenericResponse<Object, Object>(null, "could not delete"), HttpStatus.INTERNAL_SERVER_ERROR);

        }


        return new ResponseEntity<>(new GenericResponse<Object, Object>(null, "could not create"), HttpStatus.NO_CONTENT);


    }


}

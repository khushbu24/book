package com.book.controller;

import com.book.dao.ArticleDao;
import com.book.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
@Controller
//@EnableJpaRepositories("ArticleDao")
@Component
public class ArticleController {

    @Autowired
    private ArticleDao articleDao;

    @GetMapping(path="/find")

    @ResponseBody
    public String findArticleById(@RequestParam("id") Integer id) {
        System.out.println("request received id : " + id);

        Article a = articleDao.findArticleById(id);
        System.out.println(a.toString());
        System.out.println("responding");
        return "temp";
    }


}

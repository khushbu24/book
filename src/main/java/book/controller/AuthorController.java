package book.controller;

import book.dao.AuthorDao;
import book.entity.Author;
import book.entity.Title;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RestController
@RequestMapping(path = "/author")
public class AuthorController {

    @Autowired
    private AuthorDao authorDao;

    @GetMapping(path="/id")
    public Map<String,Object> getAuthorInfo(@RequestParam Integer id){

        Map<String,Object> response=new HashMap<>();
        response.put("data",null);
        response.put("error",null);

        List<Author> authorList=authorDao.getBookByAuthorId(id);

        if(authorList.size()==0){
            Map<String,Object> errorMessage=new HashMap<>();
            errorMessage.put("message","No Author Found By This id");
            response.put("error",errorMessage);
            return response;
        }

        response.put("data",authorList.get(0));
        return response;

    }
}

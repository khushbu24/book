package com.book.dao;

import com.book.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface IArticleDao extends CrudRepository<Article, Long> {

}

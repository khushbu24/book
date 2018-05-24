package com.book.dao;

import com.book.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Repository
public class ArticleDao implements CrudRepository<Article, Long> {

    @Autowired
    //private IArticleDao iArticleDao;
    private CrudRepository crudRepository;

    @Override
    public Article save(Article entity) {

        return (Article) crudRepository.save(entity);

    }

    public Article findArticleById(long id) {
        return (Article) crudRepository.findOne(id);
    }

    @Override
    public <S extends Article> Iterable<S> save(Iterable<S> entities) {
        return null;
    }

    @Override
    public Article findOne(Long aLong) {
        return null;
    }

    @Override
    public boolean exists(Long aLong) {
        return false;
    }

    @Override
    public List<Article> findAll() {
        return (List<Article>) crudRepository.findAll();
    }

    @Override
    public Iterable<Article> findAll(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public void delete(Article entity) {

    }

    @Override
    public void delete(Iterable<? extends Article> entities) {

    }

    @Override
    public void deleteAll() {

    }
}

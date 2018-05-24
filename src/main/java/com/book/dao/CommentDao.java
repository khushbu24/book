package com.book.dao;

import com.book.entity.Article;
import com.book.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Repository
public class CommentDao implements CrudRepository<Comment, Long> {

    @Autowired
    private CrudRepository crudRepository;

    @Override
    public <S extends Comment> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Comment> Iterable<S> save(Iterable<S> entities) {
        return null;
    }

    @Override
    public Comment findOne(Long aLong) {
        return (Comment) crudRepository.findOne(aLong);
    }

    @Override
    public boolean exists(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Comment> findAll() {
        return null;
    }

    @Override
    public Iterable<Comment> findAll(Iterable<Long> longs) {
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
    public void delete(Comment entity) {

    }

    @Override
    public void delete(Iterable<? extends Comment> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
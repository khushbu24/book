package com.book.dao;

import com.book.entity.Author;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Author> getBookByAuthorId(Integer id){
        String  hql="From Author where id=?";
        return entityManager.createQuery(hql).setParameter(1,id).getResultList();
    }
    public List<Author> getBookByFirstName(String fn){
        String  hql="From Author where First_name=?";
        return entityManager.createQuery(hql).setParameter(1,fn).getResultList();
    }
    public List<Author> getBookByLasttName(String ln){
        String  hql="From Author where Last_name=?";
        return entityManager.createQuery(hql).setParameter(1,ln).getResultList();
    }
    public List<Author> getBookByAddress(String address){
        String  hql="From Author where Address=?";
        return entityManager.createQuery(hql).setParameter(1,address).getResultList();
    }
}

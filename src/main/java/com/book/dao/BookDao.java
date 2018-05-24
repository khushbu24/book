package com.book.dao;


import com.book.entity.Title;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDao {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Title> getBookByIsbn(Integer isbn){
        String  hql="From Title where ISBN=?";
        return entityManager.createQuery(hql).setParameter(1,isbn).getResultList();
    }

    public List<Title> getBookByBookTitle(String book_Title){
        String  hql="From Title where book_Title=?";
        return entityManager.createQuery(hql).setParameter(1,book_Title).getResultList();
    }
    public List<Title> getBookByedition_Number(String edition_Number){
        String  hql="From Title where book_Title=?";
        return entityManager.createQuery(hql).setParameter(1,edition_Number).getResultList();
    }
    public List<Title> getBookBycopy_right(String copy_right){
        String  hql="From Title where book_Title=?";
        return entityManager.createQuery(hql).setParameter(1,copy_right).getResultList();
    }
}

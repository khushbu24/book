package book.dao;


import book.entity.Book;
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

    public List<Book> getBookByIsbn(Integer isbn){
        String  hql="From Book where ISBN=?";
        return entityManager.createQuery(hql).setParameter(1,isbn).getResultList();
    }

    public List<Book> getBookByBookTitle(String book_Title){
        String  hql="From Book where book_Title=?";
        return entityManager.createQuery(hql).setParameter(1,book_Title).getResultList();
    }
    public List<Book> getBookByedition_Number(String edition_Number){
        String  hql="From Book where book_Title=?";
        return entityManager.createQuery(hql).setParameter(1,edition_Number).getResultList();
    }
    public List<Book> getBookBycopy_right(String copy_right){
        String  hql="From Book where book_Title=?";
        return entityManager.createQuery(hql).setParameter(1,copy_right).getResultList();
    }
}

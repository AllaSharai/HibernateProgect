package com.alla.sharai.service;

import com.alla.sharai.dao.AuthorDao;
import com.alla.sharai.domain.Author;
import java.util.List;

public class AuthorService {

    private final AuthorDao authorDao;


    public AuthorService() {
        this.authorDao = new AuthorDao();
    }


    public void persist(Author entity) {
        authorDao.openCurrentSessionWithTransaction();
        authorDao.persist(entity);
        authorDao.closeCurrentSessionWithTransaction();
    }

    public void update(Author entity) {
        authorDao.openCurrentSessionWithTransaction();
        authorDao.update(entity);
        authorDao.closeCurrentSessionWithTransaction();
    }

    public Author findById(int id) {
        authorDao.openCurrentSession();
        Author book = authorDao.findById(id);
        authorDao.closeCurrentSession();
        return book;
    }

    public void delete(int id) {
        authorDao.openCurrentSessionWithTransaction();
        Author book = authorDao.findById(id);
        authorDao.delete(book);
        authorDao.closeCurrentSessionWithTransaction();
    }

    public List<Author> findAll() {
        authorDao.openCurrentSession();
        List<Author> books = authorDao.findAll();
        authorDao.closeCurrentSession();
        return books;
    }

    public void deleteAll() {
        authorDao.openCurrentSessionWithTransaction();
        authorDao.deleteAll();
        authorDao.closeCurrentSessionWithTransaction();
    }

    public AuthorDao authorDao() {
        return authorDao;
    }

}

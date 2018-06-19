package com.alla.sharai.service;

import com.alla.sharai.dao.BookDao;
import com.alla.sharai.dao.GenreDao;
import com.alla.sharai.domain.Book;
import com.alla.sharai.domain.Genre;
import java.util.List;

public class BookService {
    private static BookDao bookDao;
    private static GenreDao genreDao;


    public BookService() {
        bookDao = new BookDao();
        genreDao = new GenreDao();
    }


    public void persist(Book entity) {
        bookDao.openCurrentSessionWithTransaction();
        bookDao.persist(entity);
        bookDao.closeCurrentSessionWithTransaction();
    }

    public void update(Book entity) {
        bookDao.openCurrentSessionWithTransaction();
        bookDao.update(entity);
        bookDao.closeCurrentSessionWithTransaction();
    }

    public Book findById(int id) {
        bookDao.openCurrentSession();
        Book book = bookDao.findById(id);
        bookDao.closeCurrentSession();
        return book;
    }

    public void delete(int id) {
        bookDao.openCurrentSessionWithTransaction();
        Book book = bookDao.findById(id);
        bookDao.delete(book);
        bookDao.closeCurrentSessionWithTransaction();
    }

    public List<Book> findAll() {
        bookDao.openCurrentSession();
        List<Book> books = bookDao.findAll();
        bookDao.closeCurrentSession();
        return books;
    }

    public void deleteAll() {
        bookDao.openCurrentSessionWithTransaction();
        bookDao.deleteAll();
        bookDao.closeCurrentSessionWithTransaction();
    }


    public BookDao bookDao() {
        return bookDao;
    }

    public List<Genre> getGenesList() {
        genreDao.openCurrentSession();
        List<Genre> genres = genreDao.findAll();
        genreDao.closeCurrentSession();
        return genres;
    }

    public void persistGenre(Genre genre) {
        genreDao.openCurrentSessionWithTransaction();
        genreDao.persist(genre);
        genreDao.closeCurrentSessionWithTransaction();
    }
}

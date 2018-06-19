package com.alla.sharai.service;

import com.alla.sharai.dao.UserDao;
import com.alla.sharai.domain.Book;
import com.alla.sharai.domain.User;
import java.util.List;

public class UserService {


    private static UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    public void persist(User entity) {
        userDao.openCurrentSessionWithTransaction();
        userDao.persist(entity);
        userDao.closeCurrentSessionWithTransaction();
    }

    public void update(User entity) {
        userDao.openCurrentSessionWithTransaction();
        userDao.update(entity);
        userDao.closeCurrentSessionWithTransaction();
    }

    public User findById(int id) {
        userDao.openCurrentSession();
        User user = userDao.findById(id);
        userDao.closeCurrentSession();
        return user;
    }

    public void delete(int id) {
        userDao.openCurrentSessionWithTransaction();
        User user = userDao.findById(id);
        userDao.delete(user);
        userDao.closeCurrentSessionWithTransaction();
    }

    public List<User> findAll() {
        userDao.openCurrentSession();
        List<User> users = userDao.findAll();
        userDao.closeCurrentSession();
        return users;
    }

    public void deleteAll() {
        userDao.openCurrentSessionWithTransaction();
        userDao.deleteAll();
        userDao.closeCurrentSessionWithTransaction();
    }

    public void rentBook(int id, Book book) {
        userDao.openCurrentSessionWithTransaction();
        userDao().rentBook(id, book);
        userDao.closeCurrentSessionWithTransaction();
    }

    public UserDao userDao() {
        return userDao;
    }
}

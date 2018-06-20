package com.alla.sharai.dao;

import com.alla.sharai.domain.Book;
import com.alla.sharai.domain.User;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class UserDao implements DaoInterface<User>{

    private Session currentSession;

    private Transaction currentTransaction;

    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionWithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionWithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        return configuration.buildSessionFactory(builder.build());
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    @Override
    public void persist(User entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(User entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public User findById(int id) {
        return (User) getCurrentSession().get(User.class, id);
    }

    @Override
    public void delete(User entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> findAll() {
        return (List<User>) getCurrentSession().createQuery("from User").list();
    }

    @Override
    public void deleteAll() {
        List<User> users = findAll();
        for (User entity : users) {
            delete(entity);
        }
    }

    public void rentBook(int id, Book book) {
        User user = findById(id);
        user.getRentedBooks().add(book);
        update(user);
    }


    public List<User> findByFirstName(String firstname) {
        Criteria criteria = getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("firstName", firstname));
        List<User> users = (List<User>) criteria.list();
        return users;
    }

}

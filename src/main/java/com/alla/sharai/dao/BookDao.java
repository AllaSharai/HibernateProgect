package com.alla.sharai.dao;

import com.alla.sharai.domain.Book;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class BookDao implements DaoInterface<Book> {

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
    public void persist(Book entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Book entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Book findById(int id) {
        return (Book) getCurrentSession().get(Book.class, id);
    }

    @Override
    public void delete(Book entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Book> findAll() {
        return (List<Book>) getCurrentSession().createQuery("from Book").list();
    }

    @Override
    public void deleteAll() {
        List<Book> books = findAll();
        for (Book entity : books) {
            delete(entity);
        }
    }
}

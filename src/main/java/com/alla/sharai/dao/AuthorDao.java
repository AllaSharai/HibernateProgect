package com.alla.sharai.dao;

import com.alla.sharai.domain.Author;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class AuthorDao implements DaoInterface<Author> {
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
    public void persist(Author entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Author entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Author findById(int id) {
        return (Author) getCurrentSession().get(Author.class, id);
    }

    @Override
    public void delete(Author entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Author> findAll() {
        return (List<Author>) getCurrentSession().createQuery("from Author").list();
    }

    @Override
    public void deleteAll() {
        List<Author> authors = findAll();
        for (Author author : authors) {
            delete(author);
        }
    }
}

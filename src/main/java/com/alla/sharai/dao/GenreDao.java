package com.alla.sharai.dao;

import com.alla.sharai.domain.Genre;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class GenreDao implements DaoInterface<Genre> {

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
    public void persist(Genre entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Genre entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Genre findById(int id) {
        return (Genre) getCurrentSession().get(Genre.class, id);
    }

    @Override
    public void delete(Genre entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Genre> findAll() {
        return getCurrentSession().createQuery("from Genre").list();
    }

    @Override
    public void deleteAll() {
        List<Genre> genres = findAll();
        for (Genre genre : genres) {
            delete(genre);
        }
    }
}

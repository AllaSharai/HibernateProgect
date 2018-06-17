package com.alla.sharai;

import com.alla.sharai.domain.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainApplication {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernateProject");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();

        User user = new User("Alla", "Sharai");
        manager.persist(user);

        tx.commit();
    }

}

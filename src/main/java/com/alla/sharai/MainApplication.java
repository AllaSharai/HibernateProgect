package com.alla.sharai;

import com.alla.sharai.domain.User;
import com.alla.sharai.logic.UsersGenerator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainApplication {

    public static void main(String[] args) {
        UsersGenerator generator = new UsersGenerator();

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernateProject");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();

        List<User> users = generator.generateUsers(500);
        for (User user : users){
            manager.persist(user);
        }

        tx.commit();
    }

}

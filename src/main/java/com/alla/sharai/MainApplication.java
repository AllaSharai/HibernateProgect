package com.alla.sharai;

import com.alla.sharai.domain.Author;
import com.alla.sharai.domain.Genre;
import com.alla.sharai.domain.User;
import com.alla.sharai.logic.AuthorGenerator;
import com.alla.sharai.logic.UsersGenerator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainApplication {

    private static final String[] genres = {"Satire", "Drama", "Action and Adventure", "Romance", "Mystery", "Horror",
            "Self help", "Health", "Guide", "Travel"};

    public static void main(String[] args) {
        UsersGenerator generator = new UsersGenerator();

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernateProject");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();

        for (String genreName : genres) {
            Genre genre = new Genre(genreName);
            manager.persist(genre);
        }

        List<User> users = generator.generateUsers(500);
        for (User user : users){
            manager.persist(user);
        }

        AuthorGenerator authorGenerator = new AuthorGenerator(manager);
        List<Author> authors = authorGenerator.generateAutors(10);
        for (Author author : authors){
            manager.persist(author);
        }



        tx.commit();
    }

}

package com.alla.sharai;

import com.alla.sharai.domain.User;
import com.alla.sharai.logic.UsersGenerator;
import com.alla.sharai.service.UserService;
import java.util.List;

public class MainApplication {

    private static final String[] genres = {"Satire", "Drama", "Action and Adventure", "Romance", "Mystery", "Horror",
            "Self help", "Health", "Guide", "Travel"};

    private static final UserService userService = new UserService();

    public static void main(String[] args) {
        UsersGenerator generator = new UsersGenerator();
//
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernateProject");
//        EntityManager manager = factory.createEntityManager();
//        EntityTransaction tx = manager.getTransaction();
//        tx.begin();
//
//        for (String genreName : genres) {
//            Genre genre = new Genre(genreName);
//            manager.persist(genre);
//        }
//
//        List<User> users = generator.generateUsers(500);
//        for (User user : users){
//            manager.persist(user);
//        }
//
//        AuthorGenerator authorGenerator = new AuthorGenerator(manager);
//        List<Author> authors = authorGenerator.generateAutors(10);
//        for (Author author : authors){
//            manager.persist(author);
//        }
//
//
//
//        tx.commit();

        List<User> users = generator.generateUsers(5);
        for (User user : users){
            userService.persist(user);
        }

//        System.out.println("Total users before removing: " + userService.findAll().size());
//        userService.deleteAll();
//        System.out.println("Total users after removing: " + userService.findAll().size());

    }

}

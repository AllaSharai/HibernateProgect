package com.alla.sharai;

import com.alla.sharai.domain.Author;
import com.alla.sharai.domain.Genre;
import com.alla.sharai.domain.User;
import com.alla.sharai.logic.AuthorGenerator;
import com.alla.sharai.logic.UsersGenerator;
import com.alla.sharai.service.AuthorService;
import com.alla.sharai.service.BookService;
import com.alla.sharai.service.UserService;
import java.util.List;

public class MainApplication {

    private static final String[] genres = {"Satire", "Drama", "Action and Adventure", "Romance", "Mystery", "Horror",
            "Self help", "Health", "Guide", "Travel"};

    private static final UserService userService = new UserService();
    private static final AuthorService authorService = new AuthorService();
    private static final BookService bookService = new BookService();

    public static void main(String[] args) {
        UsersGenerator generator = new UsersGenerator();
        AuthorGenerator authorGenerator = new AuthorGenerator();

        for (String genreName : genres) {
            Genre genre = new Genre(genreName);
            bookService.persistGenre(genre);
        }

        List<User> users = generator.generateUsers(5);
        for (User user : users){
            userService.persist(user);
        }

        List<Author> authors = authorGenerator.generateAuthors(5);
        for (Author author : authors){
            authorService.persist(author);
        }

        //cleanDB();
    }

//    private static void cleanDB() {
//        userService.deleteAll();
//        authorService.deleteAll();
//    }

}

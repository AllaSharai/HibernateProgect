package com.alla.sharai;

import com.alla.sharai.domain.Author;
import com.alla.sharai.domain.Book;
import com.alla.sharai.domain.Genre;
import com.alla.sharai.domain.User;
import com.alla.sharai.logic.AuthorGenerator;
import com.alla.sharai.logic.UsersGenerator;
import com.alla.sharai.service.AuthorService;
import com.alla.sharai.service.BookService;
import com.alla.sharai.service.UserService;
import java.util.List;
import java.util.Random;

public class FillDataApplication {

    private static final String[] genres = {"Satire", "Drama", "Action and Adventure", "Romance", "Mystery", "Horror",
            "Self help", "Health", "Guide", "Travel"};

    private static final Random rand = new Random();

    private static final UserService userService = new UserService();
    private static final AuthorService authorService = new AuthorService();
    private static final BookService bookService = new BookService();

    public static void main(String[] args) {
        cleanDB();

        UsersGenerator generator = new UsersGenerator();
        AuthorGenerator authorGenerator = new AuthorGenerator();

        for (String genreName : genres) {
            Genre genre = new Genre(genreName);
            bookService.persistGenre(genre);
        }

        System.out.println("Added book genres !!!");

        List<User> users = generator.generateUsers(5);
        for (User user : users){
            userService.persist(user);
        }


        System.out.println("Added users !!!");

        List<Author> authors = authorGenerator.generateAuthors(5);
        for (Author author : authors){
            authorService.persist(author);
        }

        System.out.println("Added authors and books !!!");

        List<Book> books = bookService.findAll();
        for (User user : users){
            userService.rentBook(user, books.get(rand.nextInt(books.size())));
        }

        System.out.println("Rented some books !!!");

        System.out.println("DONE!!!");
    }

    private static void cleanDB() {
        userService.deleteAll();
        authorService.deleteAll();
    }

}

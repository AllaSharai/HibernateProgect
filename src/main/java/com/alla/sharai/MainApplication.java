package com.alla.sharai;

import com.alla.sharai.domain.User;
import com.alla.sharai.service.AuthorService;
import com.alla.sharai.service.BookService;
import com.alla.sharai.service.UserService;
import java.util.List;

public class MainApplication {



    private static final UserService userService = new UserService();
    private static final AuthorService authorService = new AuthorService();
    private static final BookService bookService = new BookService();




    public static void main(String[] args) {
        //readAuthor();
        //readUser();
        //deleteUser();
        //findAllUsers();
        //findBook();
        findByFirstName();
    }

    private  static void findByFirstName(){
        List<User> user = userService.findByFirstName("Franz");
        System.out.println("Get user with name Franz:  " + user);
    }
//    private static void findBook(){
//        Book book = bookService.findById(53);
//        System.out.println("Get book with id 53 " + book);
//
//    }

//    private static void findAllUsers(){
//        List<User> userList =  userService.findAll();
//        System.out.println("We have " + userList.size() + " users");
//
//    }

//    private static void deleteUser(){
//        User user = userService.delete(18);
//        System.out.println("Delete user with id 18");
//
//    }

//    private static void readUser() {
//        User user = userService.findById(16);
//        System.out.println("Get user with id 16 " + user);
//
//
//    }



//    private static void readAuthor() {
//        Author author = authorService.findById(11);
//        System.out.println("Get author with id 11 " + author);
//        List<Book> books = author.getBooks();
//        Author author2 = authorService.findById(13);
//        System.out.println("Get author with id 13 " + author2);
//        author2.getBooks().addAll(books);
//        authorService.update(author2);
//        System.out.println("Updated author with id 13 " + author2);
//    }



}

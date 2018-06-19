package com.alla.sharai.logic;

import com.alla.sharai.domain.Author;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AuthorGenerator {
    private final Random rand = new Random();
    private final BookGenerator bookGenerator;

    private final String[] name = { "Gabriel Garcia Marquez", "Judi Barrett", "Dale Carnegie", "Mark Haddon",
            "Lauren Weisberger", "Chelsea Handler", "Tom Wolfe", "Mindy Kaling", "K. Dick", "Celeste Ng"};

    public AuthorGenerator() {
        bookGenerator = new BookGenerator();
    }

    private Author generateAuthor(){
        Author author = new Author(getRandomName());
        author.setBooks(bookGenerator.generateBooks(rand.nextInt(10)));
        return author;
    }

    public List<Author> generateAuthors(int count){
        List<Author> authors = new ArrayList<>();
        for (int i = 0; i < count; i++){
            authors.add(generateAuthor());
        }
        return authors;
    }

    private String getRandomName() {
        int n = rand.nextInt(name.length);
        return name[n];
    }

}

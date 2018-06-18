package com.alla.sharai.logic;

import com.alla.sharai.domain.Author;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;

public class AuthorGenerator {
    private final Random rand = new Random();
    private final BookGenerator bookGenerator;

    private final String[] name = { "Gabriel Garcia Marquez", "Judi Barrett", "Dale Carnegie", "Mark Haddon",
            "Lauren Weisberger", "Chelsea Handler", "Tom Wolfe", "Mindy Kaling", "K. Dick", "Celeste Ng"};

    private final EntityManager entityManager;

    public AuthorGenerator(EntityManager manager) {
        this.entityManager = manager;
        bookGenerator = new BookGenerator(manager);
    }

    public Author generateAutor(){
        Author author = new Author(getRandomName());
        author.setBooks(bookGenerator.generateBooks(rand.nextInt(10)));
        return author;
    }

    public List<Author> generateAutors(int count){
        List<Author> authors = new ArrayList<>();
        for (int i = 0; i < count; i++){
            authors.add(generateAutor());
        }
        return authors;
    }

    private String getRandomName() {
        int n = rand.nextInt(name.length);
        return name[n];
    }

}

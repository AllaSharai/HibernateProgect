package com.alla.sharai.logic;

import com.alla.sharai.domain.Book;
import com.alla.sharai.domain.Genre;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

class BookGenerator {

    private final Random rand = new Random();

    private final String[] titles = {"Do Androids Dream of Electric Sheep?", "Everything I Never Told You",
                                    "Is Everyone Hanging Out Without Me?", "The Electric Kool-Aid Acid Test",
                                    "Are You There, Vodka? It's Me, Chelsea", "The Devil Wears Prada",
                                    "The Curious Incident of the Dog in the Night-Time","How to Win Friends and Influence People",
                                    "Cloudy with a Chance of Meatballs", "Love in the Time of Cholera"};

    private final List<Genre> genres;

    BookGenerator(EntityManager manager) {
        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<Genre> query = criteriaBuilder.createQuery(Genre.class);
        Root<Genre> from = query.from(Genre.class);
        CriteriaQuery<Genre> select = query.select(from);
        TypedQuery<Genre> queryFromManager = manager.createQuery(select);
        this.genres = queryFromManager.getResultList();
    }

    public List<Book> generateBooks(int count) {
        List<Book> books = new ArrayList<>();

        for (int i = 0; i < count; i++){
            books.add(generateBook());
        }

        return books;
    }

    private Book generateBook(){
        Book book = new Book(getRandomTitle(), getRandomGenre());
        return book;

    }

    private String getRandomTitle() {
        int n = rand.nextInt(titles.length);
        return titles[n];
    }

    private Genre getRandomGenre() {
        return genres.get(rand.nextInt(genres.size()));
    }

}

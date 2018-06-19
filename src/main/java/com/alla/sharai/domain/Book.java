package com.alla.sharai.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Book {

    @Id
    @SequenceGenerator(name = "book_SEQUENCE", sequenceName = "book_id_seq" )
    @GeneratedValue(generator = "book_SEQUENCE" )
    private int id;
    private String title;

    @ManyToOne(cascade = {CascadeType.DETACH})
    private Genre genres;

    public Book() {
    }

    public void setGenres(Genre genres) {
        this.genres = genres;
    }

    public Book(String title, Genre genre){
        this.title = title;
        this.genres = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenres() {
        return genres;
    }

    public void setGenres(String randomGenres) {
        this.genres = genres;
    }
}

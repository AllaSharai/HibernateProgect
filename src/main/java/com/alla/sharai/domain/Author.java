package com.alla.sharai.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Author {

    @Id
    @SequenceGenerator(name = "autor_SEQUENCE", sequenceName = "autor_id_seq")
    @GeneratedValue(generator = "autor_SEQUENCE")
    private int id;
    String name;

    @ManyToMany(cascade = {CascadeType.ALL})
    private List<Book> books = new ArrayList<>();

    public Author() {

    }

    public Author(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}

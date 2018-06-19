package com.alla.sharai.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Genre {

    @Id
    @SequenceGenerator(name = "genre_SEQUENCE", sequenceName = "genre_id_seq")
    @GeneratedValue(generator = "genre_SEQUENCE")
    private int id;
    String name;

    public Genre() {

    }

    public Genre(String name) {
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

    public void setName(String genre) {
        this.name = genre;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "\n\tid=" + id +
                ",\n\tname='" + name + '\'' +
                '}';
    }
}

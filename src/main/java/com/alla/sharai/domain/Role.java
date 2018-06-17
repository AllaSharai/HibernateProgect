package com.alla.sharai.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Role {
    @Id
    private int id;
    String name;


    public String getName() {
        return name;
    }

    public void setName(String user) {
        this.name = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

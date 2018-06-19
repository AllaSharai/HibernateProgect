package com.alla.sharai.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Address {

    @Id
    @SequenceGenerator(name = "address_SEQUENCE", sequenceName = "address_id_seq" )
    @GeneratedValue(generator = "address_SEQUENCE" )
    private int id;
    private String city;
    private String street;
    private int number;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "address")
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Address{" +
                "\nid=" + id +
                ",\ncity='" + city + '\'' +
                ",\nstreet='" + street + '\'' +
                ",\nnumber=" + number +
                '}';
    }
}

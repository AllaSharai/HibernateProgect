package com.alla.sharai.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class User {

    @Id
    @SequenceGenerator(name = "user_SEQUENCE", sequenceName = "user_id_seq" )
    @GeneratedValue(generator = "user_SEQUENCE", strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    private List<Book> rentedBooks = new ArrayList<>();

    public User() {
    }

    public User(String firstName, String lastName, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Book> getRentedBooks() {
        return rentedBooks;
    }

    public void setRentedBooks(List<Book> rentedBooks) {
        this.rentedBooks = rentedBooks;
    }

    @Override
    public String toString() {
        return "\n\n\tUser{" +
                "\n\tid=" + id +
                ",\n\tfirstName='" + firstName + '\'' +
                ",\n\tlastName='" + lastName + '\'' +
                ",\n\taddress=" + address +
                ",\n\trentedBooks=" + rentedBooks +
                '}';
    }
}

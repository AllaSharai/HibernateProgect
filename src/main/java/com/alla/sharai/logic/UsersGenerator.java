package com.alla.sharai.logic;

import com.alla.sharai.domain.Address;
import com.alla.sharai.domain.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UsersGenerator {

    private final Random rand = new Random();

    private final String[] lastNames = {"Kennith", "Marica", "Aja", "Ramonita", "Parthenia", "Jerlene", "Felisha"};
    private final String[] names = {"Pirtle", "Cyr", "Arora", "Rappa", "Franz", "Pew", "Below"};
    private final String[] streetNames = {"Stoneleigh Place", "Buckfast Street", "Abbot's Place", "Abbotswell Road",
                                    "Herald Street", "Hazel Grove", "Acorn Street", "Corn Street"};
    private final String[] cityNames = {"London", "Lodz", "NYC", "Kyiv", "Barcelona", "Krakow", "Amsterdam", "Paris"};

    public User generateUser() {
        User user = new User(getRandomName(), getRandomLastName(), generateAddress());
        return user;
    }

    public List<User> generateUsers(int count) {
        List<User> users = new ArrayList<>();

        for (int i = 0; i < count; i++){
            users.add(generateUser());
        }

        return users;
    }


    private Address generateAddress() {
        Address address = new Address();
        address.setStreet(getRandomStreetName());
        address.setCity(getRandomCityName());
        address.setNumber(rand.nextInt(400) + 1);

        return address;
    }

    private String getRandomName() {
        int n = rand.nextInt(names.length);
        return names[n];
    }

    private String getRandomLastName() {
        int n = rand.nextInt(lastNames.length);
        return lastNames[n];
    }

    private String getRandomStreetName() {
        return streetNames[rand.nextInt(streetNames.length)];
    }

    private String getRandomCityName() {
        return cityNames[rand.nextInt(cityNames.length)];
    }

}

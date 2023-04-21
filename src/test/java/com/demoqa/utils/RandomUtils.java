package com.demoqa.utils;

import com.demoqa.data.Genders;
import com.demoqa.data.Hobbies;
import com.demoqa.data.Subjects;
import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.*;


public class RandomUtils {

    private Faker faker = new Faker(new Locale("en"));
    String[] state = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"},
            cityNCR = {"Delhi", "Gurgaon", "Noida"},
            cityUttarPradesh = {"Agra", "Lucknow", "Merrut"},
            cityHaryana = {"Karnal", "Panipat"},
            cityRajasthan = {"Jaipur", "Jaiselmer"};


    public String getRandomFirstName() {
        return new Faker().name().firstName();
    }

    public String getRandomLastName() {
        return new Faker().name().lastName();
    }

    public String getRandomEmail() {
        return new Faker().internet().emailAddress();
    }

    public Genders getRandomGender() {
        return faker.options().option(Genders.values());
    }

    public String getRandomPhone() {
        return new Faker().number().digits(10);
    }

    public String[] getRandomBirthday(int minAge, int maxAge) {
        String formattedDate = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH).format(faker.date().birthday(minAge, maxAge));
        return formattedDate.split(" ");
    }

    public Subjects getRandomSubjects() {
        return faker.options().option(Subjects.values());

    }

    public Hobbies getRandomHobbies() {
        return faker.options().option(Hobbies.values());
    }

    public String getRandomAddress() {
        return new Faker().address().fullAddress();
    }

    public String getRandomState() {
        return faker.options().option(state);
    }

    public String getRandomCityAndStates(String state) {
        String city = null;
        switch (state) {
            case "NCR":
                city = faker.options().option(cityNCR);
                break;
            case "Uttar Pradesh":
                city = faker.options().option(cityUttarPradesh);
                break;
            case "Haryana":
                city = faker.options().option(cityHaryana);
                break;
            case "Rajasthan":
                city = faker.options().option(cityRajasthan);
                break;
        }
        return city;
    }
}


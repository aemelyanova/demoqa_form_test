package utils;

import com.github.javafaker.Faker;

import java.util.*;


public class JavaFakerRandomUtils {


    static Map<String, List<String>> cityStates = new HashMap<>();
    private static Faker faker = new Faker(new Locale("en"));
    static String[] genders = {"Male", "Female", "Other"},

    monthValue = {"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"},

    subjectsValue = {"Social Studies", "Maths", "Accounting", "Arts", "English",
            "Chemistry", "Computer Science", "History", "Civics", "Economics",
            "Biology", "Commerce", "Hindi", "Physics"},
            hobbies = {"Music", "Sport", "Reading"};

    public static void States(String[] args) {

        cityStates.put("NCR", Arrays.asList("Delhi", "Gurgaron", "Noida"));
        cityStates.put("Uttar Pradesh", Arrays.asList("Agra", "Lucknow", "Merrut"));
        cityStates.put("Haryana", Arrays.asList("Karnal", "Panipat"));
        cityStates.put("Rajasthan", Arrays.asList("Jaipur", "Jaiselmer"));
    }


    public static String getRandomFirstName() {
        return new Faker().name().firstName();
    }

    public static String getRandomLastName() {
        return new Faker().name().lastName();
    }

    public static String getRandomEmail() {
        return new Faker().internet().emailAddress();
    }

    public static String getRandomGender() {
        return faker.options().option(genders);
    }

    public static String getRandomPhone() {
        return new Faker().number().digits(10);
    }
//    public static String[] getRandomDate(String day, String month, String years) {
//        return new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH).
//                format(faker.date().birthday(16, 45)).split(" ");
//    }

    public static String getRandomDay() {
        return String.format("%02d", faker.number().numberBetween(1, 28));
    }

    public static String getRandomMonth() {
        return faker.options().option(monthValue);
    }

    public static String getRandomYear() {
        return faker.number().numberBetween(1950, 2015) + "";
    }

    public static String getRandomSubject() {
        return faker.options().option(subjectsValue);
    }

    public static String getRandomHobbies() {
        return faker.options().option(hobbies);
    }

    public static String getRandomAddress() {
        return new Faker().address().fullAddress();
    }

//    public static Map<String, List<String>>  getRandomStates(){
//        return faker.options().option(States(<String>));
//
//    }
//    public static Map<String, List<String>>  getRandomCity(){
//        return faker.options().option(cityStates(List<String>));
//
//    }
    //  public static HashMap getRandomCityStates(){
    //       return faker.options().option(cityStates(String key, String value);
    //   }
    //  public static HashMap getRandomCityStates() {
    //     return faker.options().option(States(cityStates());
    // }

    //Map<String, List<String>>

}



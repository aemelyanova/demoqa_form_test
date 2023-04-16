package utils;

import com.github.javafaker.Faker;;
import java.util.Locale;
import static utils.JavaFakerRandomUtils.*;

public class NamesVariableRegistrationFields {

    private static Faker faker = new Faker(new Locale("en"));

    public static String
            firstName = getRandomFirstName(),
            lastName = getRandomLastName(),
            email = getRandomEmail(),
            gender = getRandomGender(),
            phoneNumber = getRandomPhone(),
           // date = getRandomDate(),
            day = getRandomDay(),
            month = getRandomMonth(),
            year = getRandomYear(),
            subjects = getRandomSubject(),
            hobbies = getRandomHobbies(),
            picture = "photovalera.jpg",

            address = getRandomAddress();
//            stateValue = getRandomState(),
//            cityValue = getRandomCity(stateValue),

//
//    studentNameField ="Student Name",
//    studentEmailField ="Student Email",
//    genderField ="Gender",
//    mobileField ="Mobile",
//    dateBirthField ="Date of Birth",
//    subjectsField ="Subjects",
//    hobbiesField ="Hobbies",
//    pictureField ="Picture",
//    addressField ="Address",
//    stateCityField ="State and City",
//    sizesTitleField ="Thanks for submitting the form";

}
package com.demoqa.tests;


import com.demoqa.data.Genders;
import com.demoqa.data.Hobbies;
import com.demoqa.data.Subjects;
import org.junit.jupiter.api.Test;

import static com.demoqa.utils.RandomUtils.*;


public class RegistrationFormPage extends TestBase {
    @Test
    public void fillInRegistrationForm() {


        String firstName = getRandomFirstName();
        String lastName = getRandomLastName();
        String email = getRandomEmail();
        Genders genders = getRandomGender();
        String phoneNumber = getRandomPhone();
        String[] dateBirthday = getRandomBirthday(17, 70);
        Subjects subjects = getRandomSubjects();
        Hobbies hobbies = getRandomHobbies();
        String picture = "photovalera.jpg";
        String address = getRandomAddress();
        String state = getRandomState();
        String city = getRandomCityAndStates(state);


        registrationPage.openPage()
                .removeFooter()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setGender(genders)
                .setUserNumber(phoneNumber)
                .setBirthDate(dateBirthday[0], dateBirthday[1], dateBirthday[2])
                .setSubject(subjects)
                .setHobbies(hobbies)
                .setPicture(picture)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .setSubmit();

        registrationPage.verifyRegistrationResultsModalAppears()
                .verifyResult("Student Name", String.format("%s %s", firstName, lastName))
                .verifyResult("Student Email", email)
                .verifyResult("Gender", genders.toString())
                .verifyResult("Mobile", phoneNumber)
                .verifyResult("Date of Birth", String.format("%s %s,%s", dateBirthday[0], dateBirthday[1], dateBirthday[2]))
                .verifyResult("Subjects", subjects.toString())
                .verifyResult("Hobbies", hobbies.toString())
                .verifyResult("Picture", picture)
                .verifyResult("Address", address)
                .verifyResult("State and City", String.format("%s %s", state, city));

    }
}

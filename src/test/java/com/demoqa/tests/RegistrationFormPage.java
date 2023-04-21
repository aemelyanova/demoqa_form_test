package com.demoqa.tests;


import com.demoqa.data.Genders;
import com.demoqa.data.Hobbies;
import com.demoqa.data.Subjects;
import org.junit.jupiter.api.Test;


public class RegistrationFormPage extends TestBase {

    String firstName = randomUtils.getRandomFirstName();
    String lastName = randomUtils.getRandomLastName();
    String email = randomUtils.getRandomEmail();
    Genders genders = randomUtils.getRandomGender();
    String phoneNumber = randomUtils.getRandomPhone();
    String[] dateBirthday = randomUtils.getRandomBirthday(17, 70);
    Subjects subjects = randomUtils.getRandomSubjects();
    Hobbies hobbies = randomUtils.getRandomHobbies();
    String picture = "photovalera.jpg";
    String address = randomUtils.getRandomAddress();
    String state = randomUtils.getRandomState();
    String city = randomUtils.getRandomCityAndStates(state);

    @Test
    public void fillInRegistrationForm() {

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

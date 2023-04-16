package com.demoqa.tests;


import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;
import static utils.NamesVariableRegistrationFields.*;


public class StudentRegistrationFormWithJavaFakerTests extends TestBase {

    @Test
    void studentRegistrationFormTests() {


        registrationPage.openPage()
                .removeFooter()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setGender(gender)
                .setUserNumber(phoneNumber)
               // .setBirthDate(date(day, month, years))
                .setBirthDate(day, month, year)
                .setSubject(subjects)
                .setHobbies(hobbies)
                .setPicture(picture)
                .setAddress(address);
//                .setState("Haryana")
//                .setCity("Panipat")
//                .setSubmit();
        sleep(4000);

        registrationPage.verifyRegistrationResultsModalAppears()
                .verifyResult("Student Name", "Valera Petrov")
                .verifyResult("Student Email", "valerka@gmail.com")
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "1122334455")
                .verifyResult("Date of Birth", "29 January,1995")
                .verifyResult("Subjects", "Computer Science")
                .verifyResult("Hobbies", "Music")
                .verifyResult("Picture", "photovalera.jpg")
                .verifyResult("Address", "189 The Grove Drive, Los Angeles, CA 90036")
                .verifyResult("State and City", "Haryana Panipat");

    }
}

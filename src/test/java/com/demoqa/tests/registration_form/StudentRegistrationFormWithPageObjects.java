package com.demoqa.tests.registration_form;

import org.junit.jupiter.api.Test;


public class StudentRegistrationFormWithPageObjects extends TestBase {

    @Test
    void studentRegistrationFormTests() {


        registrationPage.openPage()
                .removeFooter()
                .setFirstName("Valera")
                .setLastName("Petrov")
                .setUserEmail("valerka@gmail.com")
            //    .setGender("Male")
                .setUserNumber("1122334455")
                .setBirthDate("29", "January", "1995")
          //      .setSubject("Computer Science")
           //     .setHobbies("Music")
                .setPicture("photovalera.jpg")
                .setAddress("189 The Grove Drive, Los Angeles, CA 90036")
                .setState("Haryana")
                .setCity("Panipat")
                .setSubmit();

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

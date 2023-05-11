package com.demoqa.tests;

import com.demoqa.data.Genders;
import com.demoqa.data.Hobbies;
import com.demoqa.data.Subjects;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;


public class RegistrationRemoteFormPage extends RemoteTestBase {

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
    @Tag("remote")
    public void fillInRegistrationForm() {

        step("Открываем страницу", () -> {
            registrationPage.openPage()
                    .removeFooter();
        });
        step("Ввести имя", () -> {
            registrationPage.setFirstName(firstName);
        });
        step("Ввести фамилию", () -> {
            registrationPage.setLastName(lastName);
        });
        step("Ввод email", () -> {
            registrationPage.setLastName(lastName);
        });
        step("Выбор пола", () -> {
            registrationPage.setGender(genders);
        });
        step("Ввести номер телефона", () -> {
            registrationPage.setUserNumber(phoneNumber);
        });
        step("Ввести дату рождения", () -> {
            registrationPage.setBirthDate(dateBirthday[0], dateBirthday[1], dateBirthday[2]);
        });
        step("Выбрать предмет", () -> {
            registrationPage.setSubject(subjects);
        });
        step("Загрузить фото", () -> {
            registrationPage.setPicture(picture);
        });
        step("Выбрать штат и город", () -> {
            registrationPage.setState(state)
                    .setCity(city);
        });
        step("Отправить форму", () -> {
            registrationPage.setSubmit();
        });
        step("Проверить правильность заполнения полей", () -> {
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

        });
    }
}


package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.data.Genders;
import com.demoqa.data.Hobbies;
import com.demoqa.data.Subjects;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultsModal;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {


    CalendarComponent calendarComponent = new CalendarComponent();
    ResultsModal resultsModal = new ResultsModal();

    SelenideElement formHeaderText = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            subjectsAutoMenu = $(".subjects-auto-complete__menu"),
            hobbiesInput = $("#hobbiesWrapper"),
            pictureInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#state"),
            stateCityInput = $("#stateCity-wrapper"),
            cityInput = $("#city"),
            submitInput = $("#submit");


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        formHeaderText.shouldHave(text("Student Registration Form"));

        return this;
    }

    public RegistrationPage removeFooter() {
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(Genders value) {
        genderInput.$(byText(value.toString())).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubject(Subjects value) {
        subjectsInput.setValue(value.toString()).click();
        subjectsAutoMenu.click();

        return this;
    }

    public RegistrationPage setHobbies(Hobbies value) {
        hobbiesInput.$(byText(value.toString())).click();

        return this;
    }

    public RegistrationPage setPicture(String value) {
        pictureInput.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value) {
        stateInput.click();
        stateCityInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        cityInput.click();
        stateCityInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setSubmit() {
        submitInput.click();

        return this;
    }

    public RegistrationPage verifyRegistrationResultsModalAppears() {
        resultsModal.verifyModalAppears();

        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        resultsModal.verifyResult(key, value);
        return this;

    }
}

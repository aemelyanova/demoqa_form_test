package com.demoqa.tests;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormWithPageObjects extends TestBase {


    @Test
    void StudentRegistrationFormTests() {

        // загружаем файл с фото
        File file = new File("src/test/resources/photovalera.jpg");


        registrationPage.openPage()
                        .setFirstName("Valera")
                        .setLastName("Petrov")
                        .setUserEmail("valerka@gmail.com")
                        .setGender("Male")
                        .setUserNumber("1122334455")
                        .setBirthDate("29","January", "1995");


        // выбираем предмет для изучения
        $("#subjectsInput").setValue("Computer Science").click();
        $(".subjects-auto-complete__menu").click();

        // в разделе "Hobbies" выбираем категорию
        $("#hobbiesWrapper").$(byText("Music")).click();

        // загружаем изображение
        $("#uploadPicture").uploadFile(file);

        // ввести текущий адрес
        $("#currentAddress").setValue("189 The Grove Drive, Los Angeles, CA 90036");

        //выбрать штат и город
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Panipat")).click();

        //отправить анкету
        $("#submit").click();

        //проверка
        $(".modal-content").shouldBe(visible);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Valera" + " " + "Petrov"), text("valerka@gmail.com"),
                text("Male"), text("1122334455"), text("29 January,1995"), text("Computer Science"),
                text("Music"), text("photovalera.jpg"), text("189 The Grove Drive, Los Angeles, CA 90036"),
                text("Haryana" + " " + "Panipat"));

    }
}

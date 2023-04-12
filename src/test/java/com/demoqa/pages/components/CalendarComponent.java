package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CalendarComponent {
    SelenideElement monthSelect = $(".react-datepicker__month-select"),
            yearSelect = $(".react-datepicker__year-select");

    public void setDate(String day, String month, String year) {
        monthSelect.click();
        $(byText(month)).click();
        yearSelect.click();
        $(byText(year)).click();
        $(String.format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", day)).click();
    }

}

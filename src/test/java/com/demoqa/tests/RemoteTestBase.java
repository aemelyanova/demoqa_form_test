package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.config.WebDriverConfig;
import com.demoqa.helpers.Attach;
import com.demoqa.pages.RegistrationPage;
import com.demoqa.utils.RandomUtils;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class RemoteTestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    RandomUtils randomUtils = new RandomUtils();

    static WebDriverConfig webDriverConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

    @BeforeAll
    static void configurationSiteDemoQa() {


        Configuration.browser = webDriverConfig.getBrowser();
        Configuration.baseUrl = webDriverConfig.getBaseUrl();
        Configuration.browserSize = webDriverConfig.getBrowserSize();
        Configuration.browserVersion = webDriverConfig.getBrowserVersion();
        Configuration.browserPosition = webDriverConfig.getBrowserPosition();
        Configuration.pageLoadStrategy = webDriverConfig.getPageLoadStrategy();

        if (webDriverConfig.getRemote()) {
            Configuration.remote = webDriverConfig.getRemoteUrl();

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));

            Configuration.browserCapabilities = capabilities;
        }
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
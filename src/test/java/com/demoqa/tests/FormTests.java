package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.FormPage;
import com.demoqa.pages.TestData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class FormTests {

    FormPage formPage = new FormPage();
    TestData testData = new TestData();

    @BeforeAll
    static public void config() {
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.browserSize = "1920x1080";
        Configuration.browserPosition = "0x0";
    }

    /**Тест на корректное формирование формы при заполнении обязательных полей*/
    @Test
    public void onlyRequiredFieldsTest() {
        formPage.openPage()
                .fillForm(testData)
                .checkForm(testData);
    }
}

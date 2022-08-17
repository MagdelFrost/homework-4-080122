package com.demoqa.tests;

import org.junit.jupiter.api.Test;


public class FormTests extends BaseTest {


    /**
     * Тест на корректное формирование формы при заполнении обязательных полей
     */
    @Test
    public void onlyRequiredFieldsTest() {
        formPage.openPage()
                .fillForm(testData)
                .checkForm(testData);
    }
}

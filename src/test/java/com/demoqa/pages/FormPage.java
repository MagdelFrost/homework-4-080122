package com.demoqa.pages;

import com.codeborne.selenide.selector.ByText;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultForm;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FormPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultForm resultForm = new ResultForm();

    public FormPage openPage() {
        open("automation-practice-form");

        return this;
    }

    public FormPage fillName(String firstName, String lastName) {
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);

        return this;
    }

    public FormPage fillEmail(String email) {
        $("#userEmail").setValue(email);

        return this;
    }

    public FormPage fillNumber(String number) {
        $("#userNumber").setValue(number);

        return this;
    }

    public FormPage fillGender(String gender) {
        $("#genterWrapper").find(new ByText(gender)).click();

        return this;
    }

    public FormPage fillDayOfBirth(TestData testData) {
        calendarComponent.setDate(testData.date);

        return this;
    }

    public FormPage fillHobbies(String hobbie) {
        $("#hobbiesWrapper").find(new ByText(hobbie)).click();

        return this;
    }

    public FormPage fillAddress(String address) {
        $("#currentAddress").setValue(address);

        return this;
    }

    public FormPage submit () {
        $("#submit").click();

        return this;
    }

    public FormPage fillForm(TestData testData) {
        this.fillName(testData.FIRST_NAME, testData.LAST_NAME)
                .fillEmail(testData.EMAIL)
                .fillNumber(testData.NUMBER)
                .fillGender(testData.GENDER)
                .fillDayOfBirth(testData)
                .fillHobbies(testData.HOBBY)
                .fillAddress(testData.ADDRESS)
                .submit();

        return this;
    }

    public FormPage checkForm(TestData testData) {
        resultForm.assertFormParam("Student Name", testData.FIRST_NAME + " " + testData.LAST_NAME);
        resultForm.assertFormParam("Student Email", testData.EMAIL);
        resultForm.assertFormParam("Mobile", testData.NUMBER);
        resultForm.assertFormParam("Gender", testData.GENDER);
        resultForm.assertFormParam("Date of Birth", testData.updateDateOfBirth);
        resultForm.assertFormParam("Hobbies", testData.HOBBY);
        resultForm.assertFormParam("Address", testData.ADDRESS);
        return this;
    }
}

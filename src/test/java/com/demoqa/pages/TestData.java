package com.demoqa.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TestData {

    protected final String FIRST_NAME = "John";
    protected final String LAST_NAME = "McClane";
    protected final String EMAIL = "johnmc55@gmail.com";
    protected final String NUMBER = "8495956636";
    protected final String GENDER = "Male";
    protected final String DATE_OF_BIRTH = "04.23.1955";
    protected final String HOBBY = "Sports";
    protected final String ADDRESS = "г. Москва, вн.тер.г. муниципальный округ Богородское, ул Бойцовая, " +
            "д. 17, к. 1, этаж 1, ПОМ. IА, КОМ. 2";

    LocalDate date = LocalDate.parse(DATE_OF_BIRTH, DateTimeFormatter.ofPattern("MM.dd.yyyy"));
    protected String updateDateOfBirth = date.format(DateTimeFormatter.ofPattern("dd MMMM,yyyy", new Locale("en")));
}

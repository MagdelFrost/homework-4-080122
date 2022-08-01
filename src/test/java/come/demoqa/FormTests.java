package come.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.conditions.Text;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;


public class FormTests {

    @BeforeAll
    static public void config() {
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.browserSize = "1920x1080";
        Configuration.browserPosition = "0x0";
    }

    /**Тест на корректное формирование формы при заполнении обязательных полей*/
    @Test
    public void onlyRequiredFieldsTest() {
        open("automation-practice-form");

        $("#firstName").setValue("John");
        $("#lastName").setValue("McClane");
        $("#userEmail").setValue("johnmc55@gmail.com");
        $("#userNumber").setValue("8495956636");
        $("#genterWrapper").find(new ByText("Male")).click();
        $("#dateOfBirthInput").click();
        $("[class='react-datepicker__month-select']").selectOption(4);
        $("[class='react-datepicker__year-select']").selectOption("1955");
        $("[aria-label='Choose Monday, May 23rd, 1955']").click();
        $("#hobbiesWrapper").find(new ByText("Sports")).click();
        $("#currentAddress").setValue("г. Москва, вн.тер.г. муниципальный округ Богородское, ул Бойцовая, " +
                "д. 17, к. 1, этаж 1, ПОМ. IА, КОМ. 2");
        $("#submit").click();

        $(".modal-body").find(new ByText("Student Name")).parent().lastChild()
                .shouldHave(new Text("John McClane"));
        $(".modal-body").find(new ByText("Gender")).parent().lastChild()
                .shouldHave(new Text("Male"));
        $(".modal-body").find(new ByText("Mobile")).parent().lastChild()
                .shouldHave(new Text("8495956636"));
        $(".modal-body").find(new ByText("Date of Birth")).parent().lastChild()
                .shouldHave(new Text("23 May,1955"));
        $(".modal-body").find(new ByText("Hobbies")).parent().lastChild()
                .shouldHave(new Text("Sports"));
        $(".modal-body").find(new ByText("Address")).parent().lastChild()
                .shouldHave(new Text("г. Москва, вн.тер.г. муниципальный округ Богородское, ул Бойцовая, " +
                        "д. 17, к. 1, этаж 1, ПОМ. IА, КОМ. 2"));
    }
}

package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTest extends TestBase {
    String firstName = "Arkadiy";
    String lastName = "Parovozov";
    String email = "parovoz@mail.com";
    String gender = "Other";
    String userNumber = "9516660005";
    String month = "June";
    String year = "1990";
    String subject = "Arts";
    String hobbies = "Sports";
    String currentAddress = "RZHD 1";
    String state = "Uttar Pradesh";
    String city = "Agra";

    @Test
    @Disabled
    void practiceRegistrationFillFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--022").click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $("#hobbiesWrapper").$(byText(hobbies)).click();
        $("#uploadPicture").uploadFromClasspath("img/mount.jpg");
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#state").$(byText(state)).click();
        $("#city").click();
        $("#city").$(byText(city)).click();
        executeJavaScript("$('footer').remove()");
        $("#submit").click();

        //Проверка заполненной формы
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstName), text(lastName), text(email), text(gender),
                text(userNumber), text("22 June,1990"), text(subject), text(hobbies), text("mount.jpg"),
                text(currentAddress), text(state), text(city));
    }
}

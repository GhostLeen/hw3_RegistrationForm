package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPracticePage {

    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

    public final String page_title_text = "Student Registration Form";

    private SelenideElement fillFirstName = $("#firstName");

    private SelenideElement fillLastName = $("#lastName");

    private SelenideElement fillUserEmail = $("#userEmail");

    private SelenideElement selectGender = $("#genterWrapper");

    private SelenideElement fillNumber = $("#userNumber");

    private SelenideElement selectSubject = $("#subjectsInput");

    private SelenideElement selectHobby = $("#hobbiesWrapper");

    private SelenideElement uploadFileForm = $("#uploadPicture");

    private SelenideElement fillAddress = $("#currentAddress");

    private SelenideElement selectState = $("#state");

    private SelenideElement selectCity = $("#city");

    private SelenideElement submitButton = $("#submit");

    private SelenideElement dateOfBirthInput = $("#dateOfBirthInput");

    public RegistrationPracticePage openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(page_title_text));
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPracticePage setFirstAndLastName(String valueName, String valueSurname) {
        fillFirstName.setValue(valueName);
        fillLastName.setValue(valueSurname);
        return this;
    }

    public RegistrationPracticePage setUserEmail(String value) {
        fillUserEmail.setValue(value);
        return this;
    }

    public RegistrationPracticePage selectGender(String value) {
        selectGender.$(byText(value)).click();
        return this;
    }

    public RegistrationPracticePage setUserNumber(String value) {
        fillNumber.setValue(value);
        return this;
    }

    public RegistrationPracticePage selectSubject(String value) {
        selectSubject.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPracticePage selectHobby(String value) {
        selectHobby.$(byText(value)).click();
        return this;
    }

    public RegistrationPracticePage uploadPicture(String filePath) {
        uploadFileForm.uploadFromClasspath(filePath);
        return this;
    }

    public RegistrationPracticePage setAddress(String value) {
        fillAddress.setValue(value);
        return this;
    }

    public RegistrationPracticePage selectStateAndCity(String state, String city) {
        selectState.click();
        selectState.$(byText(state)).click();
        selectCity.click();
        selectCity.$(byText(city)).click();
        return this;
    }

    public RegistrationPracticePage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public RegistrationPracticePage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPracticePage verifyResultFormAppears() {
        registrationResultsModal.verifyModalAppears();
        return this;
    }

    public RegistrationPracticePage verifyResultsForm(String key, String value) {
        registrationResultsModal.verifyModalResults(key, value);
        return this;
    }
}
package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPracticePage;

public class RegistrationWithPageObjTest extends TestBase {
    RegistrationPracticePage registrationPracticePage = new RegistrationPracticePage();

    String firstName = "Arkadiy";
    String lastName = "Parovozov";
    String email = "parovoz@mail.com";
    String gender = "Other";
    String userNumber = "9516660005";
    String day = "22";
    String month = "June";
    String year = "1990";
    String subject = "Arts";
    String hobbies = "Sports";
    String filePath = "img/mount.jpg";
    String fileName = "mount.jpg";
    String currentAddress = "RZHD 1";
    String state = "Uttar Pradesh";
    String city = "Agra";

    @Test
    void registrationFillFormTest() {
        //Заполнение формы регистрации
        registrationPracticePage.openPage()
                .setFirstAndLastName(firstName, lastName)
                .setUserEmail(email)
                .selectGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(day, month, year)
                .selectSubject(subject)
                .selectHobby(hobbies)
                .uploadPicture(filePath)
                .setAddress(currentAddress)
                .selectStateAndCity(state, city)
                .clickSubmitButton();

        //Проверка заполненной формы
        registrationPracticePage.verifyResultFormAppears()
                .verifyResultsForm("Student Name", firstName + " " + lastName)
                .verifyResultsForm("Student Email", email)
                .verifyResultsForm("Gender", gender)
                .verifyResultsForm("Mobile", userNumber)
                .verifyResultsForm("Date of Birth", day + " " + month + "," + year)
                .verifyResultsForm("Subjects", subject)
                .verifyResultsForm("Hobbies", hobbies)
                .verifyResultsForm("Picture", fileName)
                .verifyResultsForm("Address", currentAddress)
                .verifyResultsForm("State and City", state + " " + city);
    }
}
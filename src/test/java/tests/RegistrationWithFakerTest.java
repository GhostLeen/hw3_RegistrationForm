package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPracticePage;
import testData.RandomData;

public class RegistrationWithFakerTest extends TestBase {
    RegistrationPracticePage registrationPracticePage = new RegistrationPracticePage();
    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String gender = RandomData.randomGender();
    String userNumber = faker.phoneNumber().subscriberNumber(10);
    String day = String.valueOf(faker.number().numberBetween(10, 30));
    String month = RandomData.randomMonth();
    String year = String.valueOf(faker.number().numberBetween(1900, 2000));
    String subject = RandomData.randomSubject();
    String hobbies = RandomData.randomHobbies();
    String filePath = "img/mount.jpg";
    String fileName = "mount.jpg";
    String currentAddress = faker.address().streetAddress();
    String state = RandomData.randomState();
    String city = RandomData.randomCity(state);

    @Test
    void registrationFillFormTest() {
        //Заполнение формы регистрации
        registrationPracticePage.openPage()
                .setFirstAndLastName(firstName, lastName)
                .setUserEmail(userEmail)
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
                .verifyResultsForm("Student Email", userEmail)
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
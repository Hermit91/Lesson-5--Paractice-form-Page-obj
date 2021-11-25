package gmail.salokin1991.tests;

import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;


public class StudentsRegistrationWithPageObjectTests extends TestBase {

    @Test
    void firstTest() {

//        ARRANGE
        String userFirstName = fakeData.fakeName();
        String userLastName = fakeData.fakeLastName();
        String userEmail = fakeData.fakeEmail();
        String userMobNumber = fakeData.fakeMobNumber();
        String birthDay = fakeData.fakeDay();
        String birthMonth = fakeData.fakeMonth();
        String birthYear = fakeData.fakeYear();
        String userSubject1 = "History";
        String userHobby = fakeData.fakeHobby();
        String currentAddress = fakeData.fakeAddress();
        String userGender = fakeData.fakeGender();
        String currentState = fakeData.fakeState();
        String currentCity = fakeData.fakeCity();
        String meme = "img/meme.jpg";

//        ACT
        step("Open students registration form", () -> {
            registrationPage.openPage();
        });

        step("Fill students registration form", () -> {
            step("Set birth date, than close fixeban", () -> {
                registrationPage.calendar.setBirthdayDate(birthDay, birthMonth, birthYear);
                registrationPage.closeFixeban();
            });
            step("Fill basic info", () -> {
                registrationPage.typeFirstName(userFirstName)
                        .typeLastName(userLastName)
                        .selectGender(userGender);
            });
            step("Fill contacts", () -> {
                registrationPage.typeEmail(userEmail)
                        .typeNumber(userMobNumber);
            });
            step("Set interests, than scroll to submit button", () -> {
                registrationPage.selectHobby(userHobby)
                        .selectSubject(userSubject1)
                        .scrollToSubmit();
            });
            step("Set address", () -> {
                registrationPage.typeAddress(currentAddress)
                        .selectState(currentState)
                        .selectCity(currentCity);
            });
            step("Upload image", () -> {
                registrationPage.uploadImg(meme);
            });
            step("Submit form", () -> {
                registrationPage.submit();
            });
        });

//        ASSERT
        step("Verify successful form submit", () -> {
            registrationPage.submitForm.checkUserBasicInfo(userFirstName, userLastName, userGender);
            registrationPage.submitForm.checkUserBirthday(birthDay, birthMonth, birthYear);
            registrationPage.submitForm.checkUserContactInfo(userEmail, userMobNumber);
            registrationPage.submitForm.checkUserAddress(currentAddress, currentState, currentCity);
            registrationPage.submitForm.checkUserInterests(userSubject1, userHobby);
            registrationPage.submitForm.checkUserFiles(meme);
        });
    }
}
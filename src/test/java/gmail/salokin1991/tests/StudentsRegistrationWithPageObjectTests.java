package gmail.salokin1991.tests;

import gmail.salokin1991.utils.FakeDataUtil2;
import org.junit.jupiter.api.Test;


public class StudentsRegistrationWithPageObjectTests extends TestBase {

    FakeDataUtil2 fakeData = new FakeDataUtil2();

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
        registrationPage.openPage()
                .calendar.setBirthdayDate(birthDay, birthMonth, birthYear);
        registrationPage.closeFixeban()
                .typeFirstName(userFirstName)
                .typeLastName(userLastName)
                .typeEmail(userEmail)
                .typeNumber(userMobNumber)
                .selectGender(userGender)
                .selectHobby(userHobby)
                .selectSubject(userSubject1)
                .scrollToSubmit()
                .typeAddress(currentAddress)
                .selectState(currentState)
                .selectCity(currentCity)
                .uploadImg(meme)
                .submit();

//        ASSERT
        registrationPage.submitForm.checkUserBasicInfo(userFirstName, userLastName, userGender);
        registrationPage.submitForm.checkUserBirthday(birthDay, birthMonth, birthYear);
        registrationPage.submitForm.checkUserContactInfo(userEmail, userMobNumber);
        registrationPage.submitForm.checkUserAddress(currentAddress, currentState, currentCity);
        registrationPage.submitForm.checkUserInterests(userSubject1, userHobby);
        registrationPage.submitForm.checkUserFiles(meme);

    }
}
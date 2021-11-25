package gmail.salokin1991.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CheckSubmitForm {
    private static String SUBMIT_TEXT = "Thanks for submitting the form";
    private SelenideElement submitTableHead = $("#example-modal-sizes-title-lg"),
            submitTable = $(".modal-body");

    public void checkUserBasicInfo(String userFirstName, String userLastName, String userGender) {
        submitTableHead.shouldHave(text(SUBMIT_TEXT));
        submitTable.shouldHave(text(userFirstName + " " + userLastName), text(userGender));
    }

    public void checkUserBirthday(String birthDay, String birthMonth, String birthYear) {
        submitTable.shouldHave(text(birthDay + " " + birthMonth + "," + birthYear));
    }

    public void checkUserContactInfo(String userEmail, String userMobNumber) {
        submitTable.shouldHave(text(userEmail), text(userMobNumber));
    }

    public void checkUserInterests(String userSubject1, String userHobby) {
        submitTable.shouldHave(text(userSubject1), text(userHobby));
    }

    public void checkUserAddress(String currentAddress, String currentState, String currentCity) {
        submitTable.shouldHave(text(currentAddress), text(currentState + " " + currentCity));
    }

    public void checkUserFiles(String pictureName) {
        submitTable.shouldHave(text(pictureName.substring(4)));
    }
}

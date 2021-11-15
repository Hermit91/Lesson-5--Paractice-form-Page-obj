package gmail.salokin1991.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CheckSubmitForm {
    private static String SUBMIT_TEXT = "Thanks for submitting the form";
    private SelenideElement submitTableHead = $("#example-modal-sizes-title-lg"),
            submitTable = $(".modal-body");

    public void checkSubmit(String userFirstName, String userLastName, String userEmail, String userGender,
                            String userMobNumber, String birthDay, String birthMonth, String birthYear,
                            String userSubject1, String userHobby, String pictureName, String currentAddress,
                            String currentState, String currentCity) {

        submitTableHead.shouldHave(text(SUBMIT_TEXT));
        submitTable.shouldHave(text(userFirstName + " " + userLastName), text(userEmail),
                text(userGender), text(userMobNumber), text(birthDay + " " + birthMonth + "," + birthYear),
                text(userSubject1), text(userHobby), text(pictureName.substring(4)), text(currentAddress),
                text(currentState + " " + currentCity));
    }
}

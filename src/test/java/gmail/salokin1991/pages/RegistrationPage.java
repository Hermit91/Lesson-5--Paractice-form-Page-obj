package gmail.salokin1991.pages;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Tag;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Tag("remote")
public class RegistrationPage {

    // locators & elements

    private final String FORM_TITLE = "Student Registration Form";
    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            closeFixeban = $("#close-fixedban"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            numberInput = $("#userNumber"),
            addressInput = $("#currentAddress"),
            subjectInput = $("#subjectsInput"),
            submitSelect = $("#submit"),
            stateSelect = $("#state"),
            citySelect = $("#city"),
            imgUpload = $("#uploadPicture");

    public CalendarComponent calendar = new CalendarComponent();
    public CheckSubmitForm submitForm = new CheckSubmitForm();


    // actions

    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));

        return this;
    }

    public RegistrationPage closeFixeban() {
        closeFixeban.click();

        return this;
    }

    public RegistrationPage typeFirstName(String userFirstName) {
        firstNameInput.setValue(userFirstName);

        return this;
    }

    public RegistrationPage typeLastName(String userLastName) {
        lastNameInput.setValue(userLastName);

        return this;
    }

    public RegistrationPage typeEmail(String userEmail) {
        emailInput.setValue(userEmail);

        return this;
    }

    public RegistrationPage typeNumber(String userMobNumber) {
        numberInput.setValue(userMobNumber);

        return this;
    }

    public RegistrationPage typeAddress(String currentAddress) {
        addressInput.setValue(currentAddress);

        return this;
    }

    public RegistrationPage selectGender(String userGender) {
        $(byText(userGender)).click();

        return this;
    }

    public RegistrationPage selectSubject(String userSubject1) {
        subjectInput.click();
        subjectInput.setValue(userSubject1).pressEnter();

        return this;
    }

    public RegistrationPage selectHobby(String userHobby) {
        $(byText(userHobby)).click();

        return this;
    }

    public RegistrationPage scrollToSubmit() {
        submitSelect.scrollIntoView(true);

        return this;
    }

    public RegistrationPage selectState(String currentState) {
        stateSelect.click();
        $(byText(currentState)).click();

        return this;
    }

    public RegistrationPage selectCity(String currentCity) {
        citySelect.click();
        $(byText(currentCity)).click();

        return this;
    }

    public RegistrationPage uploadImg(String img) {
        imgUpload.uploadFromClasspath(img);

        return this;
    }

    public RegistrationPage submit() {
        submitSelect.click();

        return this;
    }
}


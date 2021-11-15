package gmail.salokin1991.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    private SelenideElement dateSelect = $("#dateOfBirthInput"),
            monthSelect = $(".react-datepicker__month-select"),
            yearSelect = $(".react-datepicker__year-select");

    public void setBirthdayDate(String birthDay, String birthMonth, String birthYear) {
        dateSelect.click();
        monthSelect.selectOption(birthMonth);
        yearSelect.selectOption(birthYear);
        $(".react-datepicker__day--0" + birthDay + ":not(.react-datepicker__day--outside-month)").click();
    }
}

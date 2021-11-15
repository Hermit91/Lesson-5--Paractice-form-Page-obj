package gmail.salokin1991.tests;

import com.codeborne.selenide.Configuration;
import gmail.salokin1991.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }
}

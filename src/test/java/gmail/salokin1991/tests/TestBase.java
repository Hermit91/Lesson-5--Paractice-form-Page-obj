package gmail.salokin1991.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import gmail.salokin1991.config.CredentialConfig;
import gmail.salokin1991.helpers.Attach;
import gmail.salokin1991.pages.RegistrationPage;
import gmail.salokin1991.utils.FakeDataUtil2;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static java.lang.String.format;

public class TestBase {

    public static CredentialConfig credentials =
            ConfigFactory.create(CredentialConfig.class);

    RegistrationPage registrationPage = new RegistrationPage();
    FakeDataUtil2 fakeData = new FakeDataUtil2();


    static String login = credentials.login();
    static String password = credentials.password();


    @BeforeAll
    static void beforeAll() {

//        String selenoidUrl = System.getProperty("selenoidUrl", "https://%s:%s@selenoid.autotests.cloud/wd/hub/");

        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.startMaximized = true;
        Configuration.remote = format("https://%s:%s@selenoid.autotests.cloud/wd/hub/", "user1", "1234");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}

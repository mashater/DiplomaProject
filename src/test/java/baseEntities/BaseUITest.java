package baseEntities;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import configurations.ReadProperties;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.*;
import steps.*;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseUITest {
    protected LoginStep loginStep;

    @BeforeTest
    public void setUp() {
        Configuration.baseUrl = ReadProperties.getUrlUi();
        Configuration.browser = ReadProperties.browserName();
        Configuration.browserSize = "1920x1080";
        Configuration.fastSetValue = false;
        //Configuration.pageLoadStrategy = PageLoadStrategy.EAGER.toString();
        SelenideLogger.addListener("Selenide", new AllureSelenide());

        open("/");
        loginStep = new LoginStep();
        loginStep.successLogin();
    }

    @AfterTest
    public void closePage() {
        closeWebDriver();
    }
}

package baseEntities;

import com.codeborne.selenide.Configuration;
import configurations.ReadProperties;
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

        open("/");
        loginStep = new LoginStep();
        loginStep.successLogin();
    }

    @AfterTest
    public void closePage() {
        closeWebDriver();
    }
}

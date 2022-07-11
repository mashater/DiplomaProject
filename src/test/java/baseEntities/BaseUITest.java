package baseEntities;

import com.codeborne.selenide.Configuration;
import configurations.ReadProperties;
import org.testng.ITestResult;
import org.testng.annotations.*;
import steps.*;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseUITest {
    protected LoginStep loginStep;

    @BeforeTest
    public void setUp (){
        Configuration.baseUrl = ReadProperties.getUrlUi();
        Configuration.browser = ReadProperties.browserName();
        Configuration.browserSize = "1920x1080";
        //Configuration.fastSetValue = true;
        Configuration.timeout = 5000;

        open ("/login");
        loginStep = new LoginStep();
        loginStep.successLogin();
    }

    @AfterTest
    public void closePage() {closeWebDriver();};

}

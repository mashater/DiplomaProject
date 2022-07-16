package tests.gui;

import baseEntities.BaseUITest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

@Epic("GUI Tests")
@Feature("Positive Tests")
public class DialogTest extends BaseUITest {

    @Test
    @Description("Check dialog box 'Upgrade your subscription'")
    public void dialogBoxTest() {
        $(By.xpath("//*[text()='Dashboards']")).click();
        $(By.xpath("//h1[text()='Upgrade your subscription']")).shouldBe(visible);
        $(By.xpath("//*[text()= 'Not now']")).click();
        $(By.xpath("//h1[text()='Upgrade your subscription']")).shouldNotBe(visible);

    }
}

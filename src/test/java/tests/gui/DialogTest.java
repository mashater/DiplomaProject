package tests.gui;

import baseEntities.BaseUITest;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class DialogTest extends BaseUITest {

    @Test
    @Description ("Dialog box")
    public void DialogBoxTest (){
        $(By.xpath("//*[text()='Dashboards']")).click();
        $(By.xpath("//h1[text()='Upgrade your subscription']")).shouldBe(visible);
        $(By.xpath("//*[text()= 'Not now']")).click();
        $(By.xpath("//h1[text()='Upgrade your subscription']")).shouldNotBe(visible);

    }
}

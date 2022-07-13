package tests.gui;

import baseEntities.BaseUITest;
import com.codeborne.selenide.SelenideElement;
import models.ProjectBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import steps.ProjectStep;
import utils.RandomString;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProjectTest extends BaseUITest {
    ProjectStep projectStep= new ProjectStep();

    @Test (priority = 1)
    public void boundaryValuesProjectTest () throws InterruptedException {

        ProjectBuilder newProject =  new ProjectBuilder.Builder()
                .withName(RandomString.getRandomString())
                .withCode(RandomString.getRandomString())
                .withDescription(RandomString.getRandomString())
                .build();

        projectStep.addProject(newProject);
        if (RandomString.getRandomString().length() != 1) {
            $(".no-project.mt-4").shouldBe(visible);
        } else {
            $(".form-control-feedback").shouldBe(visible);
        }
        Thread.sleep(6000);
}

    /*@Test
    public void incorrectBoundaryValuesProjectTest () throws InterruptedException {

        ProjectBuilder newProject1 =  new ProjectBuilder.Builder()
                .withName(RandomString.getRandomString(5))
                .withCode(RandomString.getRandomString(1))
                .withDescription(RandomString.getRandomString(10))
                .build();

        projectStep.addProjectWithIncorrectData(newProject1);
        Thread.sleep(6000);
        $(".form-control-feedback").shouldBe(visible);
    }*/

    @Test (priority = 2)
    public void updateProjectTest () throws InterruptedException {
        open("https://app.qase.io/projects");
        $(By.xpath("//*[@class=\"project-row\"][last()]/td[last()]/div/a")).click();
        $(".dropdown-menu-end.show>div>a").click();
        $("#inputTitle").click();
        $("#inputTitle").setValue("Updated");
        $("input[id=fileupload]").uploadFile(new File("src/test/resources/updated-stamp.jpg"));
        Thread.sleep(12000);
        $("[id='update']").click();
        Thread.sleep(6000);


    }
    @Test (priority = 3)
    public void deleteProjectTest () throws InterruptedException {
    open("https://app.qase.io/projects");
    projectStep.deleteProject();
}
}

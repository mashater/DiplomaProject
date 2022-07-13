package tests.gui;

import baseEntities.BaseUITest;
import com.codeborne.selenide.Selenide;
import models.ProjectBuilder;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import steps.ProjectStep;
import utils.RandomString;
import java.io.File;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class ProjectTest extends BaseUITest {
    ProjectStep projectStep= new ProjectStep();

    @Test (priority = 1)
    public void boundaryValuesProjectTest () throws InterruptedException {

        ProjectBuilder newProject =  new ProjectBuilder.Builder()
                .withName(RandomString.getRandomString(3))
                .withCode(RandomString.getRandomString(3))
                .withDescription(RandomString.getRandomString(3))
                .build();

        projectStep.addProject(newProject);
        $(".no-project.mt-4").shouldBe(visible).shouldHave(text("Looks like you don’t have any "));
}

    @Test (priority = 2)
    public void incorrectBoundaryValuesProjectTest () throws InterruptedException {

        ProjectBuilder newProject =  new ProjectBuilder.Builder()
                .withName(RandomString.getRandomString(3))
                .withCode(RandomString.getRandomString(1))
                .withDescription(RandomString.getRandomString(3))
                .build();

        open("https://app.qase.io/projects");
        projectStep.addProjectWithIncorrectData(newProject);
        $(".form-control-feedback").shouldBe(visible).shouldHave(text("The code must be at least 2 characters."));
    }

    @Test (priority = 3)
    public void updateProjectTest () throws InterruptedException {
        open("https://app.qase.io/projects");
        $(By.xpath("//*[@class=\"project-row\"][last()]/td[last()]/div/a")).click();
        $(".dropdown-menu-end.show>div>a").click();
        $("#inputTitle").click();
        $("#inputTitle").setValue("Updated");
        $("input#fileupload").sendKeys(new File("src/test/resources/updated-stamp.jpg").getAbsolutePath());
        $("#update").click();
        /*($("#flash-message-from-server")).shouldNotBe(hidden);
        Alert flash = Selenide.switchTo().alert();
        flash.getText();
        System.out.println(flash);*/


    }
    @Test (priority = 4)
    public void deleteProjectTest () throws InterruptedException {
    open("https://app.qase.io/projects");
    projectStep.deleteProject();
}
}

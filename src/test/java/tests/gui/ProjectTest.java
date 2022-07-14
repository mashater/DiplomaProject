package tests.gui;

import baseEntities.BaseUITest;
import models.ProjectBuilder;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import steps.ProjectStep;
import utils.RandomString;

import java.io.File;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ProjectTest extends BaseUITest {
    ProjectStep projectStep = new ProjectStep();

    @Test(priority = 1)
    public void createProjectTest() throws InterruptedException {

        ProjectBuilder newProject = new ProjectBuilder.Builder()
                .withName(RandomString.getRandomString(3))
                .withCode(RandomString.getRandomString(3))
                .withDescription(RandomString.getRandomString(3))
                .build();

        projectStep.addProject(newProject);
        $(".no-project.mt-4").shouldBe(visible).shouldHave(text("Looks like you don’t have any "));
    }

    @Test(priority = 2)
    public void incorrectBoundaryValuesProjectTest() throws InterruptedException {

        ProjectBuilder newProject = new ProjectBuilder.Builder()
                .withName(RandomString.getRandomString(3))
                .withCode(RandomString.getRandomString(1))
                .withDescription(RandomString.getRandomString(3))
                .build();

        open("/projects");
        projectStep.addProjectWithIncorrectData(newProject);
        $(".form-control-feedback").shouldBe(visible).shouldHave(text("The code must be at least 2 characters."));
    }

    @Test(priority = 3)
    public void updateProjectTest() throws InterruptedException {
        open("/projects");
        $(By.xpath("//*[@class=\"project-row\"][last()]/td[last()]/div/a")).click();
        $(".dropdown-menu-end.show>div>a").click();
        $("#inputTitle").click();
        $("#inputTitle").setValue("Updated");
        $("input#fileupload").sendKeys(new File("src/test/resources/updated-stamp.jpg").getAbsolutePath());
        $("#update").click();
        $("[role='alert']").shouldBe(visible);

    }

    @Test(priority = 4)
    public void deleteProjectTest() throws InterruptedException {
        open("https://app.qase.io/projects");
        projectStep.deleteProject();
        $$(".project-row")// массив элемента
                .shouldHave(size(1));
    }
}

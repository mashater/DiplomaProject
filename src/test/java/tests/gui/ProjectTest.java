package tests.gui;

import baseEntities.BaseUITest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import models.ProjectBuilder;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.AddCasesAndSuitesPage;
import steps.ProjectStep;
import utils.RandomString;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

@Epic("GUI Tests")
@Feature("Positive Tests")
public class ProjectTest extends BaseUITest {
    ProjectStep projectStep = new ProjectStep();
    AddCasesAndSuitesPage addCasesAndSuitesPage = new AddCasesAndSuitesPage();

    @Test(priority = 1)
    @Description("Create new project with correct boundary values")
    public void createProjectTest() throws InterruptedException {

        ProjectBuilder newProject = new ProjectBuilder.Builder()
                .withName(RandomString.getRandomString(3))
                .withCode(RandomString.getRandomString(2))
                .withDescription(RandomString.getRandomString(3))
                .build();

        open("/projects");
        projectStep.addProject(newProject);
        addCasesAndSuitesPage.getCreateCaseButton().shouldBe(visible).shouldHave(text(" Case"));
    }

    @Test(priority = 2)
    @Description("Create new project with incorrect boundary values")
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
    @Description("Update project's name and load image")
    public void updateProjectTest() throws InterruptedException {
        open("/projects");
        $(By.xpath("//*[@class=\"project-row\"][last()]/td[last()]/div/a")).click();
        $(".dropdown-menu-end.show>div>a").click();
        $("#inputTitle").click();
        $("#inputTitle").setValue("Updated");
        $("input#fileupload").sendKeys(new File("src/test/resources/updated-stamp.jpg").getAbsolutePath());
        $("#update").click();
        open("/projects");
        $$(".project-row")
                .find(text("Updated"))
                .shouldBe(visible);
    }

    @Test(priority = 4)
    @Description("Delete updated project")
    public void deleteProjectTest() throws InterruptedException {
        open("/projects");
        projectStep.deleteProject();
        $$(".project-row")
                .find(text("Updated"))
                .shouldNotBe(visible);
    }
}

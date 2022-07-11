package tests.gui;

import baseEntities.BaseUITest;
import models.ProjectBuilder;
import org.testng.annotations.Test;
import steps.ProjectStep;
import utils.RandomString;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProjectTest extends BaseUITest {

    @Test
    public void CorrectBoundaryValuesProjectTest () throws InterruptedException {

        ProjectStep projectStep= new ProjectStep();

        ProjectBuilder newProject =  new ProjectBuilder.Builder()
                .withName(RandomString.getRandomString(5))
                .withCode(RandomString.getRandomString(2))
                .withDescription(RandomString.getRandomString(10))
                .build();

        projectStep.addProject(newProject);
        $("#create-case-button").shouldBe(visible);
        Thread.sleep(6000);
}

    @Test
    public void IncorrectBoundaryValuesProjectTest () throws InterruptedException {

        ProjectStep projectStep= new ProjectStep();

        ProjectBuilder newProject =  new ProjectBuilder.Builder()
                .withName(RandomString.getRandomString(5))
                .withCode(RandomString.getRandomString(1))
                .withDescription(RandomString.getRandomString(10))
                .build();

        projectStep.addProjectWithIncorrectData(newProject);
        Thread.sleep(8000);
        $(".form-control-feedback").shouldBe(visible);
    }
}

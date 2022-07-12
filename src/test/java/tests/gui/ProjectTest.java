package tests.gui;

import baseEntities.BaseUITest;
import models.ProjectBuilder;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import steps.ProjectStep;
import utils.RandomString;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProjectTest extends BaseUITest {
    ProjectStep projectStep= new ProjectStep();

    @Test
    public void correctBoundaryValuesProjectTest () throws InterruptedException {

        ProjectBuilder newProject =  new ProjectBuilder.Builder()
                .withName(RandomString.getRandomString(5))
                .withCode(RandomString.getRandomString(2))
                .withDescription(RandomString.getRandomString(10))
                .build();

        projectStep.addProject(newProject);
        $("#create-case-button").shouldBe(visible);
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

    @Test
    public void updateProjectTest () throws InterruptedException {
        open("https://app.qase.io/projects");
        $(By.xpath("//*[@class=\"project-row\"][last()]/td[last()]/div/a")).click();
        $(".dropdown-menu-end.show>div>a").click();
        $("#inputTitle").click();
        $("#inputTitle").setValue("Updated");
        $("#fileupload").click();

        $("#update").click();
        Thread.sleep(6000);


    }
    //@Test
    //public void deleteProjectTest () throws InterruptedException {
    //open("https://app.qase.io/projects");
       // projectStep.deleteProject();
//}
}

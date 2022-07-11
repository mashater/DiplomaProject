package tests.gui;

import baseEntities.BaseUITest;
import configurations.ReadProperties;
import models.ProjectBuilder;
import org.testng.annotations.Test;
import pages.AddProjectPage;
import pages.LoginPage;
import pages.AllProjectsPage;
import utils.RandomString;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class loginAndCreate extends BaseUITest {

    @Test // пробный тест
    public void successLogin() {
    open(ReadProperties.getUrlUi());

    LoginPage loginPage = new LoginPage();
    AllProjectsPage projectsPage = new AllProjectsPage();
    AddProjectPage addProjectPage = new AddProjectPage();

        loginPage.emailInputLocator.setValue(ReadProperties.usernameUi());
        loginPage.passwordInputLocator.setValue(ReadProperties.passwordUi());
        loginPage.loginButtonLocator.click();

    projectsPage.getCreateNewProjectButton().shouldBe(visible).shouldHave(text("Create new project"));
    projectsPage.getCreateNewProjectButton().click();
    addProjectPage.projectNameInputLocator.setValue("addf");
    addProjectPage.projectCodeInputLocator.setValue("as");
    addProjectPage.createProjectButtonLocator.click();

}
    @Test  // пробный тест
    public void DipTest() throws InterruptedException {}

        //NavigationStep navigationStep = new NavigationStep();
        //$(".defect-title").click();
        //navigationStep.addCase();



    @Test
    public void CorrectProjectTest (){
        navigationStep.addProject();
        $("#create-case-button").shouldBe(visible);
}

    @Test
    public void IncorrectProjectTest (){
        navigationStep.addProjectWithIncorrectData();
        $(".form-control-feedback").shouldBe(visible);
    }

}

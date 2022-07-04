package tests.gui;

import configurations.ReadProperties;
import org.testng.annotations.Test;
import pages.AddProjectPage;
import pages.LoginPage;
import pages.AllProjectsPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;

public class loginAndCreate {

    @Test
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

}}

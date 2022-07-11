package steps;

import configurations.ReadProperties;
import models.ProjectBuilder;
import org.openqa.selenium.By;
import pages.*;
import utils.RandomString;

public class NavigationStep {
    LoginPage loginPage = new LoginPage();
    AllProjectsPage allProjectsPage = new AllProjectsPage();
    AddProjectPage addProjectPage = new AddProjectPage();
    AddCasesAndSuitesPage addCasesAndSuitesPage = new AddCasesAndSuitesPage();
    CreateCasePage createCasePage = new CreateCasePage();
    ProjectBuilder newProject;

    public void successLogin() {
        loginPage.emailInputLocator.setValue(ReadProperties.usernameUi());
        loginPage.passwordInputLocator.setValue(ReadProperties.passwordUi());
        loginPage.getLoginButton().click();
    }
    public AllProjectsPage addProject(){
    newProject =  new ProjectBuilder.Builder()
            .withName(RandomString.getRandomString(5))
            .withCode(RandomString.getRandomString(2))
            .withDescription(RandomString.getRandomString(10))
                .build();
        allProjectsPage.getCreateNewProjectButton().click();
        addProjectPage.getProjectNameInput().sendKeys(newProject.getName());
        addProjectPage.getProjectCodeInput().sendKeys(newProject.getCode());
        addProjectPage.getCreateProjectButton().click();
        return allProjectsPage;
    }
    public AddProjectPage addProjectWithIncorrectData(){
        newProject =  new ProjectBuilder.Builder()
                .withName(RandomString.getRandomString(5))
                .withCode(RandomString.getRandomString(1))
                .withDescription(RandomString.getRandomString(10))
                .build();
        allProjectsPage.getCreateNewProjectButton().click();
        addProjectPage.getProjectNameInput().sendKeys(newProject.getName());
        addProjectPage.getProjectCodeInput().sendKeys(newProject.getCode());
        addProjectPage.getCreateProjectButton().click();
        return addProjectPage;
    }
    public AllProjectsPage deleteProject(){

        return allProjectsPage;
    }

    public AddCasesAndSuitesPage addCase (){
        addCasesAndSuitesPage.getCreateCaseButton().click();
        createCasePage.getCaseTitleInput().setValue("one");
        createCasePage.getCaseDescriptionInput().setValue("oneoneone");
        createCasePage.getCaseSaveAndCreateButton().click();
        return addCasesAndSuitesPage;

    }


}

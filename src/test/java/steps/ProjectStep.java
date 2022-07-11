package steps;

import baseEntities.BaseUIStep;
import models.ProjectBuilder;
import pages.*;

import static com.codeborne.selenide.Selenide.open;

public class ProjectStep extends BaseUIStep {


    public AllProjectsPage addProject(ProjectBuilder newProject){

        allProjectsPage.getCreateNewProjectButton().click();
        addProjectPage.getProjectNameInput().sendKeys(newProject.getName());
        addProjectPage.getProjectCodeInput().sendKeys(newProject.getCode());
        addProjectPage.getCreateProjectButton().click();

        return allProjectsPage;
    }

    public AddProjectPage addProjectWithIncorrectData(ProjectBuilder newProject){

        allProjectsPage.openPageByUrl();
        allProjectsPage.getCreateNewProjectButton().click();
        addProjectPage.getProjectNameInput().sendKeys(newProject.getName());
        addProjectPage.getProjectCodeInput().sendKeys(newProject.getCode());
        addProjectPage.getCreateProjectButton().click();
        return addProjectPage;
    }

    public AllProjectsPage deleteProject(){

        return allProjectsPage;
    }
}

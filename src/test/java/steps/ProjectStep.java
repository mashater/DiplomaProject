package steps;

import baseEntities.BaseUIStep;
import models.ProjectBuilder;
import org.openqa.selenium.By;
import pages.*;

import static com.codeborne.selenide.Selenide.$;

public class ProjectStep extends BaseUIStep {

    public AddCasesAndSuitesPage addProject(ProjectBuilder newProject) {

        allProjectsPage.getCreateNewProjectButton().click();
        addProjectPage.getProjectNameInput().sendKeys(newProject.getName());
        addProjectPage.getProjectCodeInput().clear();
        addProjectPage.getProjectCodeInput().sendKeys(newProject.getCode());
        addProjectPage.getDescriptionInput().sendKeys(newProject.getDescription());
        addProjectPage.getCreateProjectButton().click();

        return addCasesAndSuitesPage;
    }

    public AddProjectPage addProjectWithIncorrectData(ProjectBuilder newProject) {

        allProjectsPage.getCreateNewProjectButton().click();
        addProjectPage.getProjectNameInput().sendKeys(newProject.getName());
        addProjectPage.getProjectCodeInput().clear();
        addProjectPage.getProjectCodeInput().sendKeys(newProject.getCode());
        addProjectPage.getDescriptionInput().sendKeys(newProject.getDescription());
        addProjectPage.getCreateProjectButton().click();
        return addProjectPage;
    }

    public AllProjectsPage deleteProject() {

        $(By.xpath("//*[@class=\"project-row\"][last()]/td[last()]/div/a")).click();
        $(".dropdown-menu-end.show>div:last-child>a").click();
        $(By.xpath("//*[@class= 'btn btn-cancel']")).click();
        return allProjectsPage;
    }
}

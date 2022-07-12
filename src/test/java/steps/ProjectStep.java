package steps;

import baseEntities.BaseUIStep;
import models.ProjectBuilder;
import org.openqa.selenium.By;
import pages.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProjectStep extends BaseUIStep {


    public AllProjectsPage addProject(ProjectBuilder newProject){

        allProjectsPage.getCreateNewProjectButton().click();
        addProjectPage.getProjectNameInput().sendKeys(newProject.getName());
        addProjectPage.getProjectCodeInput().sendKeys(newProject.getCode());
        addProjectPage.getDescriptionInput().sendKeys(newProject.getDescription());
        addProjectPage.getCreateProjectButton().click();

        return allProjectsPage;
    }

    public AddProjectPage addProjectWithIncorrectData(ProjectBuilder newProject1){

        allProjectsPage.openPageByUrl();
        allProjectsPage.getCreateNewProjectButton().click();
        addProjectPage.getProjectNameInput().sendKeys(newProject1.getName());
        addProjectPage.getProjectCodeInput().sendKeys(newProject1.getCode());
        addProjectPage.getDescriptionInput().sendKeys(newProject1.getDescription());
        addProjectPage.getCreateProjectButton().click();
        return addProjectPage;
    }

    public AllProjectsPage deleteProject(){

        $(By.xpath("//*[@class=\"project-row\"][last()]/td[last()]/div/a")).click();
        $(".dropdown-menu-end.show>div:last-child>a").click();
        $(By.xpath("//*[@class= 'btn btn-cancel']")).click();
        return allProjectsPage;
    }
}

package baseEntities;

import pages.*;

public class BaseUIStep {
    protected LoginPage loginPage;
    protected AllProjectsPage allProjectsPage;
    protected AddProjectPage addProjectPage;
    protected AddCasesAndSuitesPage addCasesAndSuitesPage;
    protected CreateCasePage createCasePage;
    protected WorkspacePage workspacePage;
    protected InviteNewUserFormPage inviteNewUserFormPage;
    protected InvitesPage invitesPage;

    public BaseUIStep() {
        loginPage = new LoginPage();
        allProjectsPage = new AllProjectsPage();
        addProjectPage = new AddProjectPage();
        addCasesAndSuitesPage = new AddCasesAndSuitesPage();
        createCasePage = new CreateCasePage();
        workspacePage = new WorkspacePage();
        inviteNewUserFormPage = new InviteNewUserFormPage();
        invitesPage = new InvitesPage();
    }
}

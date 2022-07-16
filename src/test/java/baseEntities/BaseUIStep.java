package baseEntities;

import pages.*;

public class BaseUIStep {
    protected LoginPage loginPage;
    protected AllProjectsPage allProjectsPage;
    protected AddProjectPage addProjectPage;
    protected InviteNewUserFormPage inviteNewUserFormPage;
    protected InvitesPage invitesPage;
    protected AddCasesAndSuitesPage addCasesAndSuitesPage;

    public BaseUIStep() {
        loginPage = new LoginPage();
        allProjectsPage = new AllProjectsPage();
        addProjectPage = new AddProjectPage();
        inviteNewUserFormPage = new InviteNewUserFormPage();
        invitesPage = new InvitesPage();
        addCasesAndSuitesPage = new AddCasesAndSuitesPage();
    }
}

package steps;

import baseEntities.BaseUIStep;
import pages.InvitesPage;
import pages.WorkspacePage;

public class NavigationStep extends BaseUIStep {

    public WorkspacePage navigateToWorkspacePage() {

        workspacePage.openPageByUrl();
        return workspacePage;
    }

    public InvitesPage navigateToInvitesPage() {

        invitesPage.openPageByUrl();
        return invitesPage;
    }
}

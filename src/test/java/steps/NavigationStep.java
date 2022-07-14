package steps;

import baseEntities.BaseUIStep;
import pages.WorkspacePage;

import static com.codeborne.selenide.Selenide.open;

public class NavigationStep extends BaseUIStep {

    public WorkspacePage navigateToWorkspacePage(){

        workspacePage.openPageByUrl();
        return workspacePage;
    }

    public void navigateToInvitesPage(){
        open("/workspace/invites?page=1");
    }
}

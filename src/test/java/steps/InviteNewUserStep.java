package steps;

import baseEntities.BaseUIStep;
import models.UserBuilder;
import pages.InviteNewUserPage;
import pages.WorkspacePage;

public class InviteNewUserStep extends BaseUIStep {

    public InviteNewUserPage inviteUser (UserBuilder newUser){
        inviteNewUserPage.getInviteEmailInput().sendKeys(newUser.getEmail());
        inviteNewUserPage.getInviteRoleInput().sendKeys(newUser.getRoleTitle());
        inviteNewUserPage.getInviteConfirmButton().click();
        return inviteNewUserPage;

    }
}

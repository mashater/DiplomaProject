package steps;

import baseEntities.BaseUIStep;
import models.UserBuilder;
import pages.InviteNewUserFormPage;

public class InviteNewUserFormStep extends BaseUIStep {

    public InviteNewUserFormPage inviteUser(UserBuilder newUser) {

        inviteNewUserFormPage.getInviteEmailInput().sendKeys(newUser.getEmail());
        inviteNewUserFormPage.getInviteRoleInput().sendKeys(newUser.getRoleTitle());
        inviteNewUserFormPage.getInviteConfirmButton().click();
        return inviteNewUserFormPage;

    }
}

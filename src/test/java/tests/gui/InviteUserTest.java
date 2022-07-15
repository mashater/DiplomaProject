package tests.gui;

import baseEntities.BaseUITest;

import static com.codeborne.selenide.Condition.*;

import models.UserBuilder;
import org.testng.annotations.Test;
import pages.InvitesPage;
import steps.InviteNewUserFormStep;
import utils.RandomString;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class InviteUserTest extends BaseUITest {
    InvitesPage invitesPage = new InvitesPage();
    InviteNewUserFormStep inviteNewUserFormStep = new InviteNewUserFormStep();

    @Test
    public void oversizedInputDataTest() {
        UserBuilder newUser = new UserBuilder.Builder()
                .withEmail(RandomString.getRandomString(255) + "gmail.com")
                .withRoleTitle(RandomString.getRandomString(5))
                .build();

        open("/workspace/invites?page=1");
        invitesPage.getInviteNewMemberButton().shouldBe(visible).click();
        inviteNewUserFormStep.inviteUser(newUser);

        $("[role='alert']").shouldBe(visible).shouldHave(text("Data is invalid."));
    }

    @Test
    public void incorrectInputDataTest() {
        UserBuilder newUser = new UserBuilder.Builder()
                .withEmail("!@#%^&" + "@gmail.com")
                .withRoleTitle(RandomString.getRandomString(5))
                .build();

        open("/workspace/invites?page=1");
        invitesPage.getInviteNewMemberButton().shouldBe(visible).click();
        inviteNewUserFormStep.inviteUser(newUser);

        $("[role='alert']").shouldBe(visible).shouldHave(text("Data is invalid."));
    }

    @Test
    public void defectTest() {
        UserBuilder newUser = new UserBuilder.Builder()
                .withEmail("!@#%^&" + "@gmail.com")
                .withRoleTitle(RandomString.getRandomString(5))
                .build();

        open("/workspace/invites?page=1");
        invitesPage.getInviteNewMemberButton().shouldBe(visible).click();
        inviteNewUserFormStep.inviteUser(newUser);

        $("[role='alert']").shouldBe(visible).shouldHave(text("User has been successfully invited"));
    }
}

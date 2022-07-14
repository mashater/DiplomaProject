package tests.gui;

import baseEntities.BaseUITest;

import static com.codeborne.selenide.Condition.*;
import models.UserBuilder;
import org.testng.annotations.Test;
import pages.WorkspacePage;
import steps.InviteNewUserStep;
import steps.NavigationStep;
import utils.RandomString;
import static com.codeborne.selenide.Selenide.$;

public class InviteUserTest extends BaseUITest {
    NavigationStep navigationStep = new NavigationStep();
    WorkspacePage workspacePage = new WorkspacePage();
    InviteNewUserStep inviteNewUserStep = new InviteNewUserStep();

    @Test
    public void oversizedInputDataTest() {
        UserBuilder newUser = new UserBuilder.Builder()
                .withEmail(RandomString.getRandomString(255) + "gmail.com")
                .withRoleTitle(RandomString.getRandomString(5))
                .build();

        navigationStep.navigateToInvitesPage();
        $(".btn-primary.me-2").shouldBe(visible);
        $(".btn-primary.me-2").click();
        inviteNewUserStep.inviteUser(newUser);

        $("[role='alert']").shouldBe(visible).shouldHave(text("Data is invalid."));
    }

    @Test
    public void incorrectInputDataTest() {
        UserBuilder newUser = new UserBuilder.Builder()
                .withEmail("!@#%^&" + "@gmail.com")
                .withRoleTitle(RandomString.getRandomString(5))
                .build();

        navigationStep.navigateToInvitesPage();
        $(".btn-primary.me-2").shouldBe(visible);
        $(".btn-primary.me-2").click();
        inviteNewUserStep.inviteUser(newUser);

        $("[role='alert']").shouldBe(visible).shouldHave(text("Data is invalid."));
    }

    //@Test
    public void defectTest() {
        UserBuilder newUser = new UserBuilder.Builder()
                .withEmail("!@#%^&" + "@gmail.com")
                .withRoleTitle(RandomString.getRandomString(5))
                .build();

        navigationStep.navigateToInvitesPage();
        $(".btn-primary.me-2").shouldBe(visible);
        $(".btn-primary.me-2").click();
        inviteNewUserStep.inviteUser(newUser);

        $("[role='alert']").shouldBe(visible).shouldHave(text("User has been successfully invited"));
    }
}

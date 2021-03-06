package tests.gui;

import baseEntities.BaseUITest;

import static com.codeborne.selenide.Condition.*;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import models.UserBuilder;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.InvitesPage;
import steps.InviteNewUserFormStep;
import utils.RandomString;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Epic("GUI Tests")
@Feature("Negative Tests")
public class InviteUserTest extends BaseUITest {
    InvitesPage invitesPage = new InvitesPage();
    InviteNewUserFormStep inviteNewUserFormStep = new InviteNewUserFormStep();

    @Test
    @Description("Invite new user with exceeding email input data")
    public void oversizedInputDataTest() {
        UserBuilder newUser = new UserBuilder.Builder()
                .withEmail(RandomString.getRandomString(255) + "gmail.com")
                .withRoleTitle(RandomString.getRandomString(5))
                .build();

        open("/workspace/invites?page=1");
        $(By.xpath("//h1[text()='Invites']")).shouldBe(visible);
        invitesPage.getInviteNewMemberButton().shouldBe(visible).click();
        inviteNewUserFormStep.inviteUser(newUser);

        $("[role='alert']").shouldBe(visible).shouldHave(text("Data is invalid."));
    }

    @Test
    @Description("Invite new user with invalid email input data")
    public void incorrectInputDataTest() {
        UserBuilder newUser = new UserBuilder.Builder()
                .withEmail("!@#%^&" + "@gmail.com")
                .withRoleTitle(RandomString.getRandomString(5))
                .build();

        open("/workspace/invites?page=1");
        $(By.xpath("//h1[text()='Invites']")).shouldBe(visible);
        invitesPage.getInviteNewMemberButton().shouldBe(visible).click();
        inviteNewUserFormStep.inviteUser(newUser);

        $("[role='alert']").shouldBe(visible).shouldHave(text("Data is invalid."));
    }

    @Test
    @Description("Reproduce defect")
    public void defectTest() {
        UserBuilder newUser = new UserBuilder.Builder()
                .withEmail("!@#%^&" + "@gmail.com")
                .withRoleTitle(RandomString.getRandomString(5))
                .build();

        open("/workspace/invites?page=1");
        $(By.xpath("//h1[text()='Invites']")).shouldBe(visible);
        invitesPage.getInviteNewMemberButton().shouldBe(visible).click();
        inviteNewUserFormStep.inviteUser(newUser);

        $("[role='alert']").shouldBe(visible).shouldHave(text("User has been successfully invited"));
    }
}

package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class InviteNewUserFormPage {

    public SelenideElement inviteEmailInputLocator = $("#email");
    public SelenideElement inviteRoleInputLocator = $("#role_title");
    public SelenideElement inviteConfirmButtonLocator = $(".modal-footer>button~button");

    public SelenideElement getInviteEmailInput() {
        return inviteEmailInputLocator;
    }

    public SelenideElement getInviteRoleInput() {
        return inviteRoleInputLocator;
    }

    public SelenideElement getInviteConfirmButton() {
        return inviteConfirmButtonLocator;
    }
}

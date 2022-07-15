package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class InvitesPage {

    private static String pagePath = "https://app.qase.io/workspace/invites?page=1";
    public SelenideElement inviteNewMemberButtonLocator = $(".btn-primary.me-2");

    public void openPageByUrl() {
        open(pagePath);
    }

    public SelenideElement getInviteNewMemberButton() {
        return inviteNewMemberButtonLocator;
    }
}

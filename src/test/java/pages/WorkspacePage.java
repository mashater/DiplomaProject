package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WorkspacePage {

    private static String pagePath = "/workspace?page=1";
    public SelenideElement usersLocator = $("[title='Users']");
    public SelenideElement invitesLocator = $(By.xpath("//span[text() = 'Invites']"));


    public SelenideElement getUsersLocator() {
        return usersLocator;
    }

    public SelenideElement getInvitesLocator() {
        return invitesLocator;
    }

    public void openPageByUrl() {
        open(pagePath);
    }
}

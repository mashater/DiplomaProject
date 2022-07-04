package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public SelenideElement emailInputLocator = $("#inputEmail");
    public SelenideElement passwordInputLocator = $("#inputPassword");
    public SelenideElement loginButtonLocator = $("#btnLogin");

    public SelenideElement getEmailInput() {
        return emailInputLocator;
    }
    public SelenideElement getPasswordInput() {
        return passwordInputLocator;
    }
    public SelenideElement getLoginButton() {
        return loginButtonLocator;
    }
}

package steps;

import baseEntities.BaseUIStep;
import configurations.ReadProperties;

public class LoginStep extends BaseUIStep {

    public void successLogin() {

        loginPage.getEmailInput().setValue(ReadProperties.usernameUi());
        loginPage.getPasswordInput().setValue(ReadProperties.passwordUi());
        loginPage.getLoginButton().click();
    }
}

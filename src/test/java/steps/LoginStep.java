package steps;

import baseEntities.BaseUIStep;
import configurations.ReadProperties;

public class LoginStep extends BaseUIStep {

    public void successLogin() {

        loginPage.emailInputLocator.setValue(ReadProperties.usernameUi());
        loginPage.passwordInputLocator.setValue(ReadProperties.passwordUi());
        loginPage.getLoginButton().click();
    }
}

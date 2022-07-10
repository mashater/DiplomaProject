package steps;

import configurations.ReadProperties;
import org.openqa.selenium.By;
import pages.AddCasesAndSuitesPage;
import pages.CreateCasePage;
import pages.LoginPage;

public class NavigationStep {
    LoginPage loginPage = new LoginPage();
    AddCasesAndSuitesPage addCasesAndSuitesPage = new AddCasesAndSuitesPage();
    CreateCasePage createCasePage = new CreateCasePage();

    public void successLogin() {
        loginPage.emailInputLocator.setValue(ReadProperties.usernameUi());
        loginPage.passwordInputLocator.setValue(ReadProperties.passwordUi());
        loginPage.getLoginButton().click();
    }

    public AddCasesAndSuitesPage addCase (){
        addCasesAndSuitesPage.getCreateCaseButton().click();
        createCasePage.getCaseTitleInput().setValue("one");
        createCasePage.getCaseDescriptionInput().setValue("oneoneone");
        createCasePage.getCaseSaveAndCreateButton().click();
        return addCasesAndSuitesPage;

    }


}

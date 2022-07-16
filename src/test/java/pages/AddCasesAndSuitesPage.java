package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AddCasesAndSuitesPage {

    public SelenideElement createSuiteButtonLocator = $("#create-suite-button");
    public SelenideElement createCaseButtonLocator = $("#create-case-button");


    public SelenideElement getCreateSuiteButton() {
        return createSuiteButtonLocator;
    }

    public SelenideElement getCreateCaseButton() {
        return createCaseButtonLocator;
    }
}
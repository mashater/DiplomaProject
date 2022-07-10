package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CreateCasePage {

    public SelenideElement caseTitleInputLocator = $("#title");
    public SelenideElement caseDescriptionInputLocator = $("p[data-placeholder='For example: We can authorize on page http://example.com/login']");
    public SelenideElement caseStatusSelectLocator = $("[for='0-status']~ div > button");
    public SelenideElement caseSeveritySelectLocator = $("[for='0-severity']~ div > button");
    public SelenideElement casePrioritySelectLocator = $("[for='0-priority']~ div > button");
    public SelenideElement caseTypeSelectLocator = $("[for='0-type']~ div > button");
    public SelenideElement caseBehaviorSelectLocator = $("[for='0-behavior']~ div > button");
    public SelenideElement caseAutomationSelectLocator = $("[for='0-automation']~ div > button");
    public SelenideElement caseAddAttachmentButtonLocator = $(".add-attachment");
    public SelenideElement caseSaveButtonLocator = $("#save-case");
    public SelenideElement caseSaveAndCreateButtonLocator = $(".btn-secondary.me-1.save-button");
    public SelenideElement caseCancerButtonLocator = $(".btn-invisible-danger.b-0");

    public SelenideElement getCaseTitleInput() {
        return caseTitleInputLocator;
    }

    public SelenideElement getCaseDescriptionInput() {
        return caseDescriptionInputLocator;
    }

    public SelenideElement getCaseStatusSelect() {
        return caseStatusSelectLocator;
    }

    public SelenideElement getCaseSeveritySelect() {
        return caseSeveritySelectLocator;
    }

    public SelenideElement getCasePrioritySelect() {
        return casePrioritySelectLocator;
    }

    public SelenideElement getCaseTypeSelect() {
        return caseTypeSelectLocator;
    }

    public SelenideElement getCaseBehaviorSelect() {
        return caseBehaviorSelectLocator;
    }

    public SelenideElement getCaseAutomationSelect() {
        return caseAutomationSelectLocator;
    }

    public SelenideElement getCaseAddAttachmentButton() {
        return caseAddAttachmentButtonLocator;
    }

    public SelenideElement getCaseSaveButton() {
        return caseSaveButtonLocator;
    }

    public SelenideElement getCaseSaveAndCreateButton() {
        return caseSaveAndCreateButtonLocator;
    }

    public SelenideElement getCaseCancerButton() {
        return caseCancerButtonLocator;
    }
}

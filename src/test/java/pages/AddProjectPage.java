package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AddProjectPage {

    public SelenideElement projectNameInputLocator = $("#inputTitle");
    public SelenideElement projectCodeInputLocator = $("#inputCode");
    public SelenideElement descriptionInputLocator = $("#inputDescription");
    public SelenideElement createProjectButtonLocator = $(".btn-primary");

    public SelenideElement getProjectNameInput() {
        return projectNameInputLocator;
    }

    public SelenideElement getProjectCodeInput() {
        return projectCodeInputLocator;
    }

    public SelenideElement getDescriptionInput() {
        return descriptionInputLocator;
    }

    public SelenideElement getCreateProjectButton() {
        return createProjectButtonLocator;
    }
}

package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AllProjectsPage {

    public SelenideElement createNewProjectButtonLocator = $("#createButton");

    public SelenideElement getCreateNewProjectButton() {
        return createNewProjectButtonLocator;
    }
}

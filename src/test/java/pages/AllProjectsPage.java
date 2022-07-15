package pages;

import com.codeborne.selenide.SelenideElement;
import configurations.ReadProperties;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AllProjectsPage {

    public SelenideElement createNewProjectButtonLocator = $("#createButton");

    public SelenideElement getCreateNewProjectButton() {
        return createNewProjectButtonLocator;
    }

}

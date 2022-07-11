package steps;

import baseEntities.BaseUIStep;
import pages.AddCasesAndSuitesPage;

public class CaseStep extends BaseUIStep {

    public AddCasesAndSuitesPage addCase (){
        addCasesAndSuitesPage.getCreateCaseButton().click();
        createCasePage.getCaseTitleInput().setValue("one");
        createCasePage.getCaseDescriptionInput().setValue("oneoneone");
        createCasePage.getCaseSaveAndCreateButton().click();
        return addCasesAndSuitesPage;

    }
}

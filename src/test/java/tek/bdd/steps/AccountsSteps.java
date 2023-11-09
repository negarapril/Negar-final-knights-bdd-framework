package tek.bdd.steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import tek.bdd.pages.AccountsPage;
import tek.bdd.pages.CommonPage;
import tek.bdd.utility.SeleniumUtility;

public class AccountsSteps extends SeleniumUtility {

    @Then("the user navigate to the {string} Link")
    public void the_user_navigate_to_the_link(String linkText) {

        By locator = CommonPage.getLinkLocator(linkText);
        clickOnElement(locator);
    }

    @Then("the user should validate the {int} rows of data in default")
    public void the_user_should_validate_the_rows_of_data_in_default(int expectedRows) {
        int actualRowSize = getListOfElements(AccountsPage.accountsTableRows).size();
        Assert.assertEquals("Validate table rows",
                expectedRows,
                actualRowSize);

    }

    @Then("the user changes the Show Per Page Record to {string}")
    public void the_user_changes_the_show_per_page_option_to(String showPerPageRecord) {
        selectFromDropDown(AccountsPage.staticDropdownLocator, showPerPageRecord);
    }

    @Then("the table records per page should be {int}")
    public void the_table_records_per_page_should_be(int expectedRecords) {
        int actualRowSize = getListOfElements(AccountsPage.accountsTableRows).size();

        Assert.assertEquals("Validate table rows",
                expectedRecords,
                actualRowSize);
    }


}
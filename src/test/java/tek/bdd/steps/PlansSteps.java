package tek.bdd.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tek.bdd.pages.CommonPage;
import tek.bdd.pages.PlansPage;
import tek.bdd.utility.SeleniumUtility;

public class PlansSteps extends SeleniumUtility {

    @Given("the user click to the {string} Link")
    public void the_user_navigates_to_the_link(String linkText) {

        By locator = CommonPage.getLinkLocator(linkText);
        clickOnElement(locator);
    }

    @Then("the user should validate the {int} rows of data in present")
    public void the_user_should_validate_the_rows_of_data_in_present(int expectedRows) {
        int actualRowSize = getListOfElements(PlansPage.plansTableRows).size();
        Assert.assertEquals("Validate Table Rows",
                expectedRows,
                actualRowSize);
    }

    @When("the user validate Create Date is today's date in (EST Time zone)")
    public void the_user_validate_create_date_is_today_s_date_in_est_time_zone_as() {
        validateCreateDateIsTodayInESTTimeZone(PlansPage.dateCreatedColumn);
    }



    @When("the user validate Date Expire is a day after (EST Time Zone)")
    public void the_user_validate_date_expire_is_a_day_after_est_time_zone() {

        validateDateExpireIsDayAfterESTTimeZone(PlansPage.dateExpireColumn);
    }

}


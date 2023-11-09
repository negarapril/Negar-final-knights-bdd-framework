package tek.bdd.steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import tek.bdd.pages.HomePage;
import tek.bdd.utility.SeleniumUtility;

public class HomePageSteps extends SeleniumUtility {

    @Then("Validate the title of the page {string}")
    public void the_title_of_the_page (String expectedTitle) {
        String actualTile = getDriver().getTitle();

        Assert.assertEquals("Title Validation",
                expectedTitle,
                actualTile);

    }

    @Then("Validate the home page header as {string}")
    public void validate_the_home_page_header_as (String expectedTitle) {
        String actualTitle = getElementText(HomePage.homePageHeaderLocator);

        Assert.assertEquals("Validate Header Title",
                expectedTitle,
                actualTitle);

    }

    @Then("the {string} button should be exist")
    public void the_button_should_be_exist(String expectedButton) {
        boolean actualButton = isElementDisplayed(HomePage.createPrimaryAccountBtnLocator);
        Assert.assertTrue("The Button is not displayed in the Home Page", actualButton);
    }


}

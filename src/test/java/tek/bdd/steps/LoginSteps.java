package tek.bdd.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import tek.bdd.pages.LoginPage;
import tek.bdd.utility.SeleniumUtility;

import java.util.List;
import java.util.Map;

public class LoginSteps extends SeleniumUtility {

    @When("the user clicks on the login button")
    public void the_user_clicks_on_the_button() {

        clickOnElement(LoginPage.loginButton);

    }

    @When("the user enters the following CSR credentials:")
    public void the_user_enters_the_following_csr_credentials(DataTable dataTable) throws InterruptedException {

        List<Map<String, String>> data = dataTable.asMaps();


        String username = data.get(0).get("Username");
        String password = data.get(0).get("Password");

        enterValue(LoginPage.usernameField, username);
        enterValue(LoginPage.passwordField, password);

        Thread.sleep(2000);

    }

    @When("the user submits the sign in form")
    public void the_enters_submits_the_login_form() {
        clickOnElement(LoginPage.signButton);

    }

    @Then("the user should be on the {string} page")
    public void the_user_should_be_on_the_page(String expectedPageTitle) {

        System.out.println(expectedPageTitle);

        String actualPageTitle = getElementText(LoginPage.titleHeader);

        System.out.println(actualPageTitle);

        Assert.assertEquals("Validate page title",
                expectedPageTitle,
                actualPageTitle);

    }

    @Then("Validate the error message {string}")
    public void validate_the_error_message(String expectedErrorMessage) {

        String actualErrorMessage = getElementText(LoginPage.errorBanner);

        Assert.assertEquals("Validate error message",
                expectedErrorMessage,
                actualErrorMessage);

    }




}

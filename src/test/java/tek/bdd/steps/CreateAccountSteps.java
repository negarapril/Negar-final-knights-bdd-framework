package tek.bdd.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import tek.bdd.pages.CreateAccountPage;
import tek.bdd.utility.SeleniumUtility;
import java.util.Date;
import java.util.Map;
public class CreateAccountSteps extends SeleniumUtility {
    @When("the user navigate on the create primary account button")
    public void the_user_clicks_on_the_create_primary_account_button() {
        clickOnElement(CreateAccountPage.createPrimaryAccountBtn);
    }
    @Then("the Form Title should be {string}")
    public void the_form_title_should_be(String expectedTitle) {
        String actualTitle = getElementText(CreateAccountPage.primaryAccountFormText);
        Assert.assertEquals("Validate signup form title",
                expectedTitle,
                actualTitle);
    }

    @When("the user clicks on the create primary account button")
    public void clickCreatePrimaryAccountButton() {
        clickOnElement(CreateAccountPage.createPrimaryAccountBtn);
    }
    @When("the user fills out the form with the following data:")
    public void fillOutFormWith(Map<String, String> formData) throws InterruptedException {

        enterValue(CreateAccountPage.emailAddressField, formData.get("email"));
        selectFromDropDown(CreateAccountPage.titleField, formData.get("title"));
        enterValue(CreateAccountPage.firstNameField, formData.get("firstName"));
        enterValue(CreateAccountPage.lastNameField, formData.get("lastName"));
        selectFromDropDown(CreateAccountPage.genderField, formData.get("gender"));
        selectFromDropDown(CreateAccountPage.maritalStatusField, formData.get("maritalStatus"));
        // Calculate date of birth based on age
        // Assuming 'dateOfBirth' is the field for the age
        int age = Integer.parseInt(formData.get("dateOfBirth"));
        String calculatedDateOfBirth = calculateDateOfBirth(age);
        // Use the calculated date of birth in the form
        enterValue(CreateAccountPage.dateOfBirth, calculatedDateOfBirth);
        enterValue(CreateAccountPage.employmentStatusField, formData.get("employmentStatus"));
        Thread.sleep(2000);

    }
    @When("the user clicks on the Create Account Button")
    public void clickCreateAccountButton() throws InterruptedException {
        clickOnElement(CreateAccountPage.clickOnPrimaryAccountBtn);
        Thread.sleep(2000);
    }
    @Then("the user navigates to the {string} page")
    public void verifyNavigationToPage(String expectedSignUpTitle) {

        String actualSignUpTitle = getElementText(CreateAccountPage.signUpAccountForm);
        Assert.assertEquals("Validate sign up form title",
                expectedSignUpTitle,
                actualSignUpTitle);
    }
    @Then("the Email Address displayed on the page should be {string}")
    public void verifyEmailAddress(String expectedEmail) {
        String actualEmail = getElementText(CreateAccountPage.emailAddressDisplayed);
        Assert.assertEquals("Validate entered email",
                expectedEmail,
                actualEmail);
    }
    @When("there is an user account with the existing email address")
    public void there_is_an_user_account_with_the_existing_email_address(Map<String, String> formData) throws InterruptedException {
        enterValue(CreateAccountPage.emailAddressField, formData.get("email"));
        selectFromDropDown(CreateAccountPage.titleField, formData.get("title"));
        enterValue(CreateAccountPage.firstNameField, formData.get("firstName"));
        enterValue(CreateAccountPage.lastNameField, formData.get("lastName"));
        selectFromDropDown(CreateAccountPage.genderField, formData.get("gender"));
        // Calculate date of birth based on age
        // Assuming 'dateOfBirth' is the field for the age
        int age = Integer.parseInt(formData.get("dateOfBirth"));
        String calculatedDateOfBirth = calculateDateOfBirth(age);
        // Use the calculated date of birth in the form
        enterValue(CreateAccountPage.dateOfBirth, calculatedDateOfBirth);
        selectFromDropDown(CreateAccountPage.maritalStatusField, formData.get("maritalStatus"));
        Thread.sleep(3000);

    }

    @Then("the user should see an error message indicating {string}")
    public void the_user_should_see_an_error_message_indicating(String expectedTitle) {
        // System.out.println("Expected Title: " + expectedTitle); // for debug
        String actualTitle = getErrorMessage(CreateAccountPage.errorBanner);
        //  System.out.println("Actual Title: " + actualTitle); // for debug
        Assert.assertEquals(expectedTitle, actualTitle);
    }
}

 
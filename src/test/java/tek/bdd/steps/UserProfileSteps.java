package tek.bdd.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


import tek.bdd.pages.HomePage;
import tek.bdd.pages.LoginPage;
import tek.bdd.pages.UserProfilePage;
import tek.bdd.utility.SeleniumUtility;

import java.util.List;
import java.util.Map;


public class UserProfileSteps extends SeleniumUtility {


    @When("the user enters valid CSR credentials username {string} password {string}")
    public void the_user_enters_valid_csr_credentials_username_password(String username, String password) throws InterruptedException {
        enterValue(UserProfilePage.usernameField, username);
        enterValue(UserProfilePage.passwordField, password);
        Thread.sleep(2000);
    }

    @When("the user clicks on the sign-in button")
    public void the_user_clicks_on_the_sign_in_button() throws InterruptedException {
        clickOnElement(LoginPage.signButton);
        Thread.sleep(2000);

    }

    @When("the user clicks on the profile button")
    public void the_user_clicks_on_the_profile_button() {

        clickOnElement(UserProfilePage.profileButton);

    }

    @When("Validate the Profile Side Drawer should be {string}")
    public void validate_the_profile_side_drawer_should_be(String expectedTitle) {
        String actualTitle = getElementText(UserProfilePage.profileHeader);
        Assert.assertEquals("Title does not match",
                expectedTitle,
                actualTitle);

    }

    @Then("the information in the Profile Side Drawer should be correct")
    public void the_information_in_the_profile_side_drawer_should_be_correct(DataTable dataTable) {
        List<Map<String, String>> tableData = dataTable.asMaps(String.class, String.class);
        Map<String, String> expectedData = tableData.get(0);

        String expectedStatus = expectedData.get("Status");
        String expectedUserType = expectedData.get("User Type");
        String expectedName = expectedData.get("Name");
        String expectedUsername = expectedData.get("Username");
        String expectedAuthorities = expectedData.get("Authorities");

        String actualStatus = getElementText(UserProfilePage.profileStatus);
        String actualUserType = getElementText(UserProfilePage.profileUserType);
        String actualName = getElementText(UserProfilePage.profileName);
        String actualUsername = getElementText(UserProfilePage.profileUsername);
        String actualAuthorities = getElementText(UserProfilePage.profileAuthorities);

        Assert.assertEquals("Status does not match", expectedStatus, actualStatus);
        Assert.assertEquals("User Type does not match", expectedUserType, actualUserType);
        Assert.assertEquals("Name does not match", expectedName, actualName);
        Assert.assertEquals("Username does not match", expectedUsername, actualUsername);
        Assert.assertEquals("Authorities do not match", expectedAuthorities, actualAuthorities);
    }

    @When("the user clicks on the logout button")
    public void the_user_clicks_on_the_logout_button() {
        clickOnElement(UserProfilePage.logoutButton);
    }

    @Then("the user is redirected to the home page")
    public void the_user_is_redirected_to_the_home_page() {

        // Check for the presence of the "Create Primary Account" button
        boolean isHomePage = isElementDisplayed(HomePage.createPrimaryAccountBtnLocator);

        // Use an assertion to confirm the user is on the home page
        Assert.assertTrue("User is not redirected to the home page", isHomePage);

    }

}

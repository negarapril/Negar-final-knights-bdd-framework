@Regression_UserProfile
Feature: Validate Login and Profile Information

  Background: Repetitive steps for Profile Button
    When the user clicks on the login button
    When the user enters valid CSR credentials username "supervisor" password "tek_supervisor"
    And the user clicks on the sign-in button
    And the user clicks on the profile button

  @Smoke_ProfileSideDrawerValidation
  Scenario: CSR login and profile validation
    When Validate the Profile Side Drawer should be "Profile"
    Then the information in the Profile Side Drawer should be correct
      | Status | User Type | Name       | Username   | Authorities |
      | Active | CSR       | Supervisor | supervisor | admin       |


  @Smoke_LoginNLogout
  Scenario: CSR logs in, logs out, and returns to the home page
    And the user clicks on the logout button
    Then the user is redirected to the home page
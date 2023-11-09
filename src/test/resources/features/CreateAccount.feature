@tekInsuranceCreateAccount
Feature: TEK Insurance App Functionality

  @CreatePrimaryAccount
  Scenario: Navigate to Create Primary Account Form
    When the user navigate on the create primary account button
    Then the Form Title should be "Create Primary Account Holder"

  @FillAndSubmitPrimaryAccountForm
  Scenario: Fill and Submit Create Primary Account Holder Form with Data
    When the user navigate on the create primary account button
    And the user fills out the form with the following data:
      | Field            | Value                |
      | email            | ne74700004@gmail.com |
      | title            | Ms.                  |
      | firstName        | Neg                  |
      | lastName         | Re                   |
      | gender           | Female               |
      | maritalStatus    | Single               |
      | employmentStatus | Employed             |
      | dateOfBirth      | 50                   |
    And the user clicks on the Create Account Button
    Then the user navigates to the "Sign up your account" page
    And the Email Address displayed on the page should be "ne74700004@gmail.com"

  @CreateAccountWithExistingEmail
  Scenario: User Attempts to Register with an Existing Email Address
    When the user clicks on the create primary account button
    When there is an user account with the existing email address
      | Field         | Value            |
      | email         | ne7474@gmail.com |
      | title         | Ms.              |
      | firstName     | Sean             |
      | lastName      | Ven              |
      | gender        | Male             |
      | maritalStatus | Married          |
      | dateOfBirth   | 58               |
    And the user clicks on the Create Account Button
    Then the user should see an error message indicating "ERROR"



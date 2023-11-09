@tekInsuranceAppLogin
Feature: Tek Insurance Login Page

  @validLogin
  Scenario: User logs in with valid CSR credentials
    When the user clicks on the login button
    And the user enters the following CSR credentials:
      | Username   | Password       |
      | supervisor | tek_supervisor |
    And the user submits the sign in form
    Then the user should be on the "Customer Service Portal" page

  @invalidCredentials
  Scenario: User logs in with invalid CSR credentials
    When the user clicks on the login button
    And the user enters the following CSR credentials:
      | Username   | Password       |
      | Negar7     | tek_supervisor |
      | supervisor | Negar8         |
    And the user submits the sign in form
    Then Validate the error message "ERROR"

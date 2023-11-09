@Plans
Feature: Plans - validate the presence of 4 rows of data.

  Background: Login and navigate to Plans
    Given the user clicks on the login button
    When the user enters valid CSR credentials username "supervisor" password "tek_supervisor"
    Then the user clicks on the sign-in button
    And the user click to the "Plans" Link


  Scenario: The user navigates to Plans Page and 4 Rows of Validates Data in Presence
    Then the user should validate the 4 rows of data in present


  Scenario: Navigate to Plans Page with CSR credentials
    When the user validate Create Date is today's date in EST Time zone
    And  the user validate Date Expire is a day after EST Time Zone


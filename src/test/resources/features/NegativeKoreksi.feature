Feature: Negative Test Correction Report

  Background:
    Given Admin is logged in and on the dashboard for Laporan Koreksi

  @auth @negative
  Scenario: Search correction with invalid employee name
    When Admin navigates to Correction Report
#    And Admin inputs "Invalid Name 123" in the search field
#    And Admin clicks the Search button
#    Then No correction data should be displayed

  @negative
  Scenario: Search correction with date range that has no data
    When Admin clicks the Reset button
    And Admin selects start date "Jan 1, 2000" and end date "Jan 2, 2000"
    And Admin clicks the Search button
    Then No correction data should be displayed

  @negative
  Scenario: Reject correction without providing reason
    When Admin clicks the Reject button for the first correction
    And Admin clicks the Submit rejection button without reason
    Then A validation error should appear indicating reason is required

  @auth @negative
  Scenario: Search correction with invalid unit name
    When Admin clicks the Reset button
    And Admin clicks the Filter button
    And Admin inputs invalid unit name "UnknownDept"
    And Admin clicks the Apply button
    Then No correction data should be displayed
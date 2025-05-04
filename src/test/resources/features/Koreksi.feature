Feature: Positive Test Correction Report

  Background:
    Given Admin is logged in and on the dashboard for Laporan Koreksi

  @auth @positive
  Scenario: Admin searches employee correction by name
    When Admin navigates to Correction Report
#    And Admin inputs "Juned" in the search field
#    And Admin clicks the Search button
#    Then The correction data related to the employee name is displayed

  @positive
  Scenario: Admin searches employee correction by date
    When Admin clicks the Reset button
    And Admin selects start date "Jan 1, 2025" and end date "Apr 30, 2025"
    And Admin clicks the Search button
    Then The correction data within the selected date range is displayed

  @positive
  Scenario: Admin searches employee correction by name and date
    When Admin clicks the Reset button
    And Admin inputs "Juned" in the search field
    And Admin selects start date "Jan 1, 2025" and end date "Apr 30, 2025"
    And Admin clicks the Search button
    Then The correction data filtered by name and date is displayed

  @auth @positive
  Scenario: Admin searches employee correction by unit name
    When Admin clicks the Reset button
    And Admin clicks the Filter button
    And Admin inputs unit name "Sysmex"
    And Admin clicks the Apply button
    Then The correction data related to the unit name is displayed

#  @positive
#  Scenario: Admin approves a correction
#    When Admin clicks the Approve button for the first correction
#    And Admin clicks the Confirm button
#    Then A success popup should appear
#
#  @positive
#  Scenario: Admin rejects a correction
#    When Admin clicks the Reject button for the first correction
#    And Admin inputs rejection reason "Alasan tidak valid"
#    And Admin clicks the Submit rejection button
#    Then A success popup should appear

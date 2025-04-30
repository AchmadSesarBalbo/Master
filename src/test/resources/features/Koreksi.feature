Feature: Positive Test Cases - Correction Report

  Background:
    Given Admin is logged in and on the dashboard for Laporan Koreksi

  Scenario: Search employee by name and date range (manual input)
    When Admin navigates to Correction Report
    And Admin enters "Juned" in the search bar
    And Admin inputs start date "Jan 1, 2025" and end date "Apr 30, 2025"
    And Admin clicks Search
    Then Employee information should be displayed
    # Expected Result: Employee information appears
    # Actual Result: (to be filled after test)

  Scenario: Reset correction report filters
    When Admin clicks Reset button
    Then The page should reset to initial empty state
    # Expected Result: Page looks fresh/empty again
    # Actual Result: (to be filled after test)

  Scenario: Search employee by date range (click only, no name)
    When Admin click start date "Jan 1, 2025" and end date "Apr 30, 2025"
    And Admin clicks Search
    Then Employee information should be displayed
    # Expected Result: Employee information appears
    # Actual Result: (to be filled after test)

#  Scenario: Approve a correction request
#    When Admin clicks the approve button on a correction request
#    And Admin confirms the approval
#    Then The correction request status should be updated
    # Expected Result: Status changed to approved
    # Actual Result: (to be filled after test)
#
#  Scenario: Reject a correction request
#    When Admin clicks the approve button on a correction request
#    And Admin clicks the reject button
#    And Admin inputs rejection reason "Alasan tidak valid"
#    And Admin confirms the rejection
#    Then The correction request status should be updated to "Rejected"
#    # Expected Result: Status changed to rejected
#    # Actual Result: (to be filled after test)
#
#  Scenario: Cancel approval action
#    When Admin clicks the approve button on a correction request
#    And Admin clicks the cancel button during approval
#    Then Admin should return to Correction Report without updating the status
#    # Expected Result: Approval canceled, no status changed
#    # Actual Result: (to be filled after test)
#
#  Scenario: Cancel rejection action
#    When Admin navigates to Correction Report
#    And Admin clicks the approve button on a correction request
#    And Admin clicks the reject button
#    And Admin clicks the cancel button during rejection
#    Then Admin should return to Correction Report without updating the status
#    # Expected Result: Rejection canceled, no status changed
#    # Actual Result: (to be filled after test)
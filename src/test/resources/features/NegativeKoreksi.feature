#Feature: Laporan Koreksi
#
#  Background:
#    Given Admin is logged in and on the dashboard for Laporan Koreksi
#
#  @negative
#  Scenario: Search employee without date range and without name
#    When Admin navigates to Correction Report
#    And Admin clicks Search without entering any filter
#    Then No employee information should be displayed
#
#  @negative
#  Scenario: Search employee with date range but without name
#    When Admin inputs start date "2024-04-01" and end date "2024-04-30"
#    And Admin clicks Search without entering a name
#    Then No employee information should be displayed
#
#  @negative
#  Scenario: Filter employee by unit without valid data
#    When Admin filters correction report by unit "IT Support"
#    Then No employee information should be displayed by unit
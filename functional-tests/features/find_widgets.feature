Feature: Find widgets
  Test ability to search for widgets

  Scenario: Find widget on Java site
    Given I am on the Java home page
    When I search for Widget id 2
    Then widget id 2 is displayed
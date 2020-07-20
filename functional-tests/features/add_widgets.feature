Feature: Add widgets
  Test ability to add new widgets

  Scenario Outline: Add widget on Ruby site
    Given I am on the Ruby new widget page
    When I create for Widget name: <name>, purpose: <purpose> and size: <size>
    Then new widget <name> is displayed

    Examples:
    | name  | purpose  | size |
    | Test1 | purpose1 | 1    |
    | Test2 | purpose2 | 2    |
    | Test3 | purpose3 | 3    |

  Scenario Outline: Add widget on Ruby site and view on Java site
    Given I am on the Ruby new widget page
    When I create for Widget name: <name>, purpose: <purpose> and size: <size>
    And navigate to the widget page on the java site
    Then widget with name: <name> and purpose: <purpose> is displayed

    Examples:
      | name  | purpose  | size |
      | Test4 | purpose4 | 4    |
      | Test5 | purpose5 | 5    |
      | Test6 | purpose6 | 6    |
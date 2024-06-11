Feature: Amazon Search Feature

  Scenario Outline: Amazon Search
    Given Open the Amazon Website
    And Enter the given product: <product>
    And wait for <waitSecond> seconds
    Then Verify the results display the given product: <product>

    Examples:
      | product | waitSecond |
      | Laptop  | 30         |
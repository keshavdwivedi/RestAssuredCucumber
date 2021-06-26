Feature: Validate Delete product functionality
  I want to delete the product as per id passed

  Scenario Outline: To validate delete product functionality as per given id
    Given I have the id of the product to be deleted
    When I post delete request to delete request API endpoint
    Then I validate response code as <responseCode>
    Examples:
      | responseCode |
      | 200          |
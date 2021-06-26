Feature: Validate get all product functionality
  I want to get first 10 orders from using this feature

  Scenario Outline: To validate get order feature with valid data for 10 products
    Given I want to get details of <productCount> products
    When I get the products details of <productCount> products using Get all product API endpoint
    Then I validate status code as <statusCode>
    And I validate product count as <totalCount>
    Examples:
      | productCount | statusCode | totalCount |
      | 10           | 200        | 51958      |




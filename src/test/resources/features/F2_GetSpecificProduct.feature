Feature: Validate get specific product functionality
  I want to get the details of product as per provided product id

  Scenario Outline: To validate get details of product as per id provided
    Given I have the id of the product whose details are to be fetched
    When I get the product details as per given id
    Then I get details of product along with status code as <statusCode>
    Examples:
      | statusCode |
      | 200        |

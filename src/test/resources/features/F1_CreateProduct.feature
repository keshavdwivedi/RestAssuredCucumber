Feature: Validate creation of new product
  I want to validate the creation of new product

 Scenario Outline: To validate create product by using valid data
   Given I create product by using create new product API
   When I provide valid data for product creation
     | name      | type  | price | shipping | upc   | description | manufacturer | model | url       | image |
     | iPhone SE | Phone | 30000 | 3000     | RT500 | Test        | Apple        | SE    | apple.com | Image |
   And I store id of the product
   Then I validate status code <statusCode>
   Examples:
     | statusCode |
     | 201        |



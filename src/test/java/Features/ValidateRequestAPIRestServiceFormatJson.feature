Feature: Validate REST API with JSON Response
  @ApiTest
  Scenario: Get user information from a JSON API GET using OBJECT to manage response
    Given the API GET endpoint is "https://fakestoreapi.com/products/1"
    When I send a GET request to the API
    Then the response status code should be 200
    And the response should contain the following details using OBJECTtoResponse:
      | id               | 1                                                 |
      | title            | Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops |
      | price            | 109.95                                            |
      | description      | Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday |
      | category         | men's clothing                                    |
      | image            | https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg |
      | rating.rate      | 3.9                                               |
      | rating.count     | 120                                               |
  @ApiTest
  Scenario: Get user information from a JSON API GET using Json path
    Given the API GET endpoint is "https://fakestoreapi.com/products/1"
    When I send a GET request to the API
    Then the response status code should be 200
    And the response should contain the following details usingJSONPath:
      | id               | 1                                                 |
      | title            | Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops |
      | price            | 109.95                                            |
      | description      | Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday |
      | category         | men's clothing                                    |
      | image            | https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg |
      | rating.rate      | 3.9                                               |
      | rating.count     | 120                                               |
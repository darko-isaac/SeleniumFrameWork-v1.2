Feature: Validate POST request to 'https://jsonplaceholder.typicode.com/posts'
@ApiTest
  Scenario: Verify the successful creation of a new post
    Given the API POST endpoint is "https://jsonplaceholder.typicode.com/posts"
  When I send a POST request with the following data:
    | title | body | userId |
    | foo        | bar      | 1          |
    Then the response status code should be <204>
    And the response body should contain the following data:
      | id  | title | body | userId |
      | 101 | f9o   | bar  | 1      |
  Scenario: Verify the successful creation of a new post2
    Given the API POST endpoint is "https://jsonplaceholder.typicode.com/posts"
    When I send a POST request with the following data:
      | title | body | userId |
      | foo        | bar      | 1          |
    Then the response status code should be <204>
    And the response body should contain the following data:
      | id  | title | body | userId |
      | 101 | foo   | bar  | 1      |
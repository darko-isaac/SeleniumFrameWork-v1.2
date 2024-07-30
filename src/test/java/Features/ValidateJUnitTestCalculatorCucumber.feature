Feature: Calculator Multiplication
  @JunitTest
  Scenario: Multiply two positive numbers
    Given I have two numbers <3> and <3>
    When I multiply them
    Then the result should be <9>
  @JunitTest
  Scenario: Multiply by zero
    Given I have a number <5> and zero
    When I multiply them
    Then the result should be zero
  @JunitTest
  Scenario: Multiply two negative numbers
    Given I have two numbers <-4> and <-3>
    When I multiply them
    Then the result should be <12>

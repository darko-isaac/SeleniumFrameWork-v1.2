package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.example.Calculadora;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculaterTestCucumber {

    private int num1;
    private int num2;
    private int result;

    private Calculadora calculadora;

    @Given("I have two numbers <{int}> and <{int}>")
    public void i_have_two_numbers_and(int number1, int number2) {
        this.num1 = number1;
        this.num2 = number2;
        this.calculadora = new Calculadora();
    }

    @Given("I have a number <{int}> and zero")
    public void i_have_a_number_and_zero(int number) {
        this.num1 = number;
        this.num2 = 0;
        this.calculadora = new Calculadora();
    }

    @When("I multiply them")
    public void i_multiply_them() {
        result = calculadora.multiplicar(num1, num2);
    }

    @Then("the result should be <{int}>")
    public void the_result_should_be(int expectedResult) {
        assertEquals(expectedResult, result);
    }

    @Then("the result should be zero")
    public void the_result_should_be_zero() {
        assertTrue(calculadora.isnull(result));
    }


}

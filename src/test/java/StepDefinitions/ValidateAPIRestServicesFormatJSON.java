package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.jetbrains.annotations.NotNull;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ValidateAPIRestServicesFormatJSON {

    private String apiUrl;
    private Response response;

    @Given("the API GET endpoint is {string}")
    public void the_API_endpoint_is(String endpoint) {
        RestAssured.baseURI = endpoint;
        this.apiUrl = endpoint;
    }

    @When("I send a GET request to the API")
    public void i_send_a_GET_request_to_the_API() {
        this.response = given().when().get(apiUrl);
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.getStatusCode());
    }

    @Then("the response should contain the following details from the first value:")
    public void the_response_should_contain_the_following_details_from_first_value(@NotNull Map<String, String> expectedDetails) {
        for (Map.Entry<String, String> entry : expectedDetails.entrySet()) {
            String field = entry.getKey();
            String expectedValue = entry.getValue();

            String actualValue = response.jsonPath().getString(field);
            assertEquals(expectedValue, actualValue, "Field: " + field);
        }
    }

    @Then("the response should contain the following details using OBJECTtoResponse:")
    public void thenTheResponseShouldContainTheFollowingDetails(Map<String, String> expectedDetails) {
        assertNotNull(response, "Response should not be null");

        for (Map.Entry<String, String> entry : expectedDetails.entrySet()) {
            String field = entry.getKey();
            String expectedValueColumnName = entry.getValue();

            Object actualValueObject = extractActualValue(field, response.getBody().asString());
            String actualValue = Objects.toString(actualValueObject, "null");

            assertEquals(expectedValueColumnName, actualValue, "Field: " + field);
        }
    }

    private Object extractActualValue(String field, String jsonResponse) {
        String[] fieldPath = field.split("\\.");

        Object actualValue = null;
        Map<String, Object> responseMap = response.jsonPath().getMap("");
        for (String path : fieldPath) {
            actualValue = responseMap.get(path);
            if (actualValue instanceof Map) {
                responseMap = (Map<String, Object>) actualValue;
            }
        }
        return actualValue;
    }

    @Then("the response should contain the following details usingJSONPath:")
    public void thenTheResponseShouldContainTheFollowingDetailsJSONpath(Map<String, String> expectedDetails) {
        assertNotNull(response, "Response should not be null");

        for (Map.Entry<String, String> entry : expectedDetails.entrySet()) {
            String field = entry.getKey();
            String expectedValueColumnName = entry.getValue();

            String actualValue = response.jsonPath().getString(field);
            assertEquals(expectedValueColumnName, actualValue, "Field: " + field);
        }
    }
}
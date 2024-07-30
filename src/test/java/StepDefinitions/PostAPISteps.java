package StepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import java.util.List;
import java.util.Map;


import static io.restassured.RestAssured.given;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;

public class PostAPISteps {
    private String apiUrl;
    private Response response;

    @Given("the API POST endpoint is {string}")
    public void setApiUrlForPost(String apiUrl) {
        this.apiUrl = apiUrl;
        RestAssured.baseURI = apiUrl;
    }

    @When("I send a POST request with the following data:")
    public void sendPostRequest(io.cucumber.datatable.DataTable dataTable) {
        // Assuming you have only one set of data, you can get the first item
        var dataMap = dataTable.asMaps(String.class, String.class).get(0);

        String requestBody = "{\n" +
                "  \"title\": \"" + dataMap.get("title") + "\",\n" +
                "  \"body\": \"" + dataMap.get("body") + "\",\n" +
                "  \"userId\": " + dataMap.get("userId") + "\n" +
                "}";

        response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post();
    }


    @Then("the response status code should be <{int}>")
    public void verifyStatusCode(int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.getStatusCode());
    }

    @Then("the response body should contain the following data:")
    public void verifyResponseBody(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> expectedDataList = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> expectedData : expectedDataList) {
            response.then()
                    .body("id", equalTo(Integer.parseInt(expectedData.get("id"))))
                    .body("title", equalTo(expectedData.get("title")))
                    .body("body", equalTo(expectedData.get("body")))
                    .body("userId", equalTo(Integer.parseInt(expectedData.get("userId"))));
        }
    }
}

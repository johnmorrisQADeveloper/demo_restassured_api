package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.testng.Assert;
import utilities.RestAssuredExtension;

public class StepDefinition {
    public static ResponseOptions<Response> response;

    @Given("I perform GET operation for {string}")
    public void iPerformGETOperationFor(String url) {
        response = RestAssuredExtension.GetOps(url);
    }

    @Then("I should see {string} version to be {string}")
    public void iShouldSeeVersionToBe(String arg0, String arg1) {
        Assert.assertEquals(response.getBody().jsonPath().get(arg0), arg1, "Correct swagger version returned");
    }

    @Then("I should see text value of {string} object")
    public void iShouldSeeTextValueOfObject(String arg0) {
        String expected = "Create a short automated test for this API. Check that the data returned by the API is valid, and that ensure that each valid operation can be successfully called for each endpoint. Once you've built the tests, push the answer to Github or Gitlab, and send us a link. ";
        Assert.assertEquals(response.getBody().jsonPath().get(arg0), expected, "Correct todo text returned");
    }
}

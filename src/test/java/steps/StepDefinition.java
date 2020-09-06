package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.testng.Assert;
import utilities.RestAssuredExtension;
import java.util.List;

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

    @Then("I should see {string} users")
    public void iShouldSeeUsers(String expectedUsers) {
        List<String> jsonResponse = response.getBody().jsonPath().getList("$");
        String actualUsers = Integer.toString(jsonResponse.size());
        Assert.assertEquals(actualUsers, expectedUsers, "Correct number of users returned");
    }

    @Then("I should see property {string} to be {string}")
    public void iShouldSeePropertyReturn(String property, String expectedValue) {
        JsonPath jsonResponse = response.getBody().jsonPath();
        String actualValue = jsonResponse.get(property).toString();
        Assert.assertEquals(actualValue, expectedValue, "Correct property and value returned");
    }

    @Then("I should get {string} status code")
    public void iShouldGetStatusCode(String statusCode) {
        String actualStatusCode = String.valueOf(response.getStatusCode());
        Assert.assertEquals(actualStatusCode, statusCode, "Correct status returned");
    }

    @Then("I should see below properties")
    public void iShouldSeeBelowProperties(DataTable table) {
        JsonPath jsonResponse = response.getBody().jsonPath();
        List<List<String>> rows = table.asLists(String.class);
        for (List<String> columns : rows) {
            String actualValue = jsonResponse.get(columns.get(0)).toString();
            Assert.assertEquals(actualValue, columns.get(1).toString(), "Correct properties returned");
        }
    }

    @Then("I should see property {string} with text:")
    public void iShouldSeePropertyWithText(String property, List<String> multiline) {
        JsonPath jsonResponse = response.getBody().jsonPath();
        String actualValue = jsonResponse.get(property).toString();
        Assert.assertEquals(actualValue, multiline.get(0), "Correct text returned");
    }
}

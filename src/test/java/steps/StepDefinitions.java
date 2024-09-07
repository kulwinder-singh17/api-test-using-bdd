package steps;

import com.aventstack.extentreports.Status;
import com.example.auto.base.ApiService;
import com.example.auto.util.Constants;
import com.example.auto.util.ExtentTestManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;

public class StepDefinitions {

    ApiService api = new ApiService(Constants.BASE_URL);
    Response response;

    @Given("check weather of {string} using GET")
    public void check_weather_of(String string) {
        response = api.getRequest(Constants.GET_WEATHER_CURRENT + string);
        ExtentTestManager.getTest().log(Status.INFO, "Request: " + Constants.BASE_URL + Constants.GET_WEATHER_CURRENT + string);
        ExtentTestManager.getTest().log(Status.INFO, "Response Code: " + response.getStatusCode());
        ExtentTestManager.getTest().info("Response Body:").info("<pre>" + response.getBody().asString() + "</pre>");
    }

    @Then("status code should be {int}")
    public void status_code_should_be(int int1) {
        Assert.assertTrue("Response status code is not " + int1, response.getStatusCode() == int1);
    }

}

package org.tektutor;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.junit.Assert.assertEquals;

public class Steps {

    private RequestSpecification request;
    private Response response;
    private int actualResponseCode, expectedResponseCode;

    @Given("The microservice is deployed")
    public void the_microservice_is_deployed() {
    }

    @When("I invoke endpoint {string}")
    public void i_invoke_endpoint(String url) {
        RestAssured.baseURI = url;
        request = RestAssured.given();
        request.header( "Content-Type", "application/json" );
		response = request.get();    
    }
    
    @Then("I expect the response code to be {string}")
    public void i_expect_the_response_to_be(String strExpectedResponseCode) {
        actualResponseCode = response.getStatusCode();
        expectedResponseCode = 200;
        assertEquals ( expectedResponseCode, actualResponseCode );
    }
}
package api_stepDefinition;

import static io.restassured.RestAssured.given;

import Utilities.JSONDataReader;
import Utilities.LoggerReader;
import Utilities.configReader;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.testCaseData;

public class Patch_SD {
	RequestSpecification request;
	Response response;
	int userId = Post_SD.userId;
	String firstName = Post_SD.firstName;
	private testCaseData currentTestData;
	private static final String jsondatapath = "src/test/resources/apitestdata.json";

	@Given("user creates PATCH request with base url and valid endpoint")
	public void user_creates_patch_request_with_base_url_and_valid_endpoint() {
		String testCaseId = "TC_50";
		LoggerReader.info("User ID: " + userId);
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		LoggerReader.info("authenticated without username and password");
		request = given().baseUri(configReader.getKeyValues("baseurl")).pathParam("userId", userId);
	}

	@When("user sends patch Request with valid user Id with Request Body")
	public void user_sends_patch_request_with_valid_user_id_with_request_body() {

		response = request.request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader.info("Sent PATCH by UserID request with noAuth: " + response.getStatusLine());
	}

	@Then("user receives {int} Unauthorised Status with response body")
	public void user_receives_unauthorised_status_with_response_body(Integer int1) {

		response.then().statusCode(currentTestData.getExpectedStatusCode())
				.statusLine(currentTestData.getExpectedStatusLine())
				.contentType(currentTestData.getExpectedContentType());
		LoggerReader.info("Validated unauthorized response: " + response.getStatusLine());
	}

	@Given("user creates PATCH request with base url and valid endpoint with auth")
	public void user_creates_patch_request_with_base_url_and_valid_endpoint_with_auth() {

		String testCaseId = "TC_51";
		LoggerReader.info("User ID: " + userId);
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		LoggerReader.info("authenticated with username and password");
		request = given().baseUri(configReader.getKeyValues("baseurl")).pathParam("userId", userId);
	}

	@When("user sends Request with valid user Id and updated First Name in Request Body")
	public void user_sends_request_with_valid_user_id_and_updated_first_name_in_request_body() {

		response = request.header("Content-Type", "application/json").body(currentTestData).request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader.info("Sent PATCH by UserID request with Auth: " + response.getStatusLine());
	}

	@Then("user receives {int} OK Status with response body")
	public void user_receives_ok_status_with_response_body(Integer int1) {
		response.then().statusCode(currentTestData.getExpectedStatusCode())
				.statusLine(currentTestData.getExpectedStatusLine())
				.contentType(currentTestData.getExpectedContentType());
		LoggerReader.info("Validated unauthorized response: " + response.getStatusLine());
	}

}

package api_stepDefinition;

import static io.restassured.RestAssured.given;

import Utilities.JSONDataReader;
import Utilities.LoggerReader;
import Utilities.configReader;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.testCaseData;

public class deleteByUserId_SD {

	RequestSpecification request;
	Response response;
	int userId = Post_SD.userId;
	String firstName = Post_SD.firstName;
	private testCaseData currentTestData;
	private static final String jsondatapath = "src/test/resources/apitestdata.json";

	@Given("User sets the valid baseurl")
	public void user_sets_the_valid_baseurl() {

		String testCaseId = "TC_52";
		LoggerReader.info("User ID: " + userId);
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		LoggerReader.info("User ID to delete: " + userId);
		request = given().baseUri(configReader.getKeyValues("baseurl")).pathParam("userId", userId);
	}

	@When("User sends delete request with valid userID")
	public void user_sends_delete_request_with_valid_user_id() {
		response = request.request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader.info("Sent Delete by UserID request with Auth: " + response.getStatusLine());
	}

	@Then("user receives {int}:ok status")
	public void user_receives_ok_status(Integer int1) {

		response.then().statusCode(currentTestData.getExpectedStatusCode())
				.statusLine(currentTestData.getExpectedStatusLine())
				.contentType(currentTestData.getExpectedContentType());
		LoggerReader.info("Successfully validated positive DELETE response " + response.getStatusLine());
	}

	@Given("User sets the valid baseurl with non existing userID")
	public void user_sets_the_valid_baseurl_with_non_existing_user_id() {

		String testCaseId = "TC_53";
		LoggerReader.info("User ID: " + userId);
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		LoggerReader.info("Non-existing User ID to delete:"+userId);
		request = given().baseUri(configReader.getKeyValues("baseurl")).pathParam("userId", userId);
	}

	@When("User sends delete request without non existing userID")
	public void user_sends_delete_request_without_non_existing_user_id() {

		response = request.request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader.info("Sent DELETE with non-existing userID: " + response.getStatusLine());

	}

	@Then("user receives status {int} NOT_FOUND")
	public void user_receives_status_not_found(Integer int1) {

		response.then().statusCode(currentTestData.getExpectedStatusCode())
				.statusLine(currentTestData.getExpectedStatusLine())
				.contentType(currentTestData.getExpectedContentType());
		LoggerReader.info("Successfully validated 404 Not Found response for invalid userId" + response.getStatusLine());
	}

}

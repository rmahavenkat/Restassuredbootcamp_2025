package api_stepDefinition;

import static io.restassured.RestAssured.given;

import Utilities.JSONDataReader;
import Utilities.LoggerReader;
import Utilities.configReader;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.testCaseData;

public class deletebyUserName_SD {

	RequestSpecification request;
	Response response;
	int userId = Post_SD.userId;
	String firstName = Post_SD.firstName;
	private testCaseData currentTestData;
	private static final String jsondatapath = "src/test/resources/apitestdata.json";

	@Given("User sets the valid baseurl with valid firstname")
	public void user_sets_the_valid_baseurl_with_valid_firstname() {

		String testCaseId = "TC_54";
		LoggerReader.info("firstName: " + firstName);
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		LoggerReader.info("authenticated with username and password");
		request = given().baseUri(configReader.getKeyValues("baseurl")).pathParam("userFirstName", firstName);
	}

	@When("User sends delete request with valid first name")
	public void user_sends_delete_request_with_valid_first_name() {

		response = request.request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader.info("Sent Delete by UserName request with Auth: " + response.getStatusLine());
	}

	@Then("user receives {int}:ok status Success")
	public void user_receives_ok_status_success(Integer int1) {

		response.then().statusCode(currentTestData.getExpectedStatusCode())
				.statusLine(currentTestData.getExpectedStatusLine())
				.contentType(currentTestData.getExpectedContentType());
		LoggerReader.info("Validated authorized response: " + response.getStatusLine());
	}

	@Given("User sets the valid baseurl with non existing username")
	public void user_sets_the_valid_baseurl_with_non_existing_username() {

		String testCaseId = "TC_55";
		LoggerReader.info("firstName: " + firstName);
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		LoggerReader.info("authenticated with username and password");
		request = given().baseUri(configReader.getKeyValues("baseurl")).pathParam("userFirstName", firstName);

	}

	@When("User sends delete request without non existing username")
	public void user_sends_delete_request_without_non_existing_username() {

		response = request.request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader.info("Sent Delete by UserName request with Auth: " + response.getStatusLine());
	}

	@Then("user receives status {int} NOT_FOUND message")
	public void user_receives_status_not_found_message(Integer int1) {

		response.then().statusCode(currentTestData.getExpectedStatusCode())
				.statusLine(currentTestData.getExpectedStatusLine())
				.contentType(currentTestData.getExpectedContentType());
		LoggerReader.info("Validated authorized response: " + response.getStatusLine());
	}

}

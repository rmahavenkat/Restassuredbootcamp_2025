package api_stepDefinition;

import Utilities.JSONDataReader;
import Utilities.LoggerReader;
import Utilities.configReader;
import io.cucumber.java.en.*;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.testCaseData;

import static org.hamcrest.Matchers.*;

public class GETAllUsers_SD {
	RequestSpecification request;
	Response response;
	private testCaseData currentTestData;
	private static final String jsondatapath = "src/test/resources/apitestdata.json";

	@Given("Admin creates GET request for the user service API with baseAuth")
	public void admin_creates_get_request_for_the_user_service_api_with_base_auth() {

		String testCaseId = "TC_01";
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		LoggerReader.info("authenticated with valid username and password");
		request = given().baseUri(configReader.getKeyValues("baseurl"));

	}

	@When("Admin sends HTTPS request with valid end point")
	public void admin_sends_https_request_with_valid_end_point() {

		response = request.request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader.info("Sent GET request with baseAuth: " + response.getStatusLine());
	}

	@Then("Admin receives {int} OK Status with response body")
	public void admin_receives_ok_status_with_response_body(Integer int1) {

		response.then().statusCode(currentTestData.getExpectedStatusCode())
				.statusLine(currentTestData.getExpectedStatusLine())
				.contentType(currentTestData.getExpectedContentType())
				.body("[0].userId", equalTo(1))
				.body("userFirstName",everyItem(instanceOf(String.class)))
				.body("userLastName",everyItem(instanceOf(String.class)))
				.body("userContactNumber",everyItem(instanceOf(Number.class)))
				.body("userEmailId",everyItem(instanceOf(String.class)))
				.body("userAddress.plotNumber",everyItem(anyOf(instanceOf(String.class), nullValue())))
				.body("userAddress.street",everyItem(anyOf(instanceOf(String.class), nullValue())))
				.body("userAddress.state",everyItem(anyOf(instanceOf(String.class), nullValue())))
				.body("userAddress.country", everyItem(anyOf(instanceOf(String.class), nullValue())))
				.body("userAddress.zipCode", everyItem(anyOf(instanceOf(Number.class), nullValue())));
		;
		LoggerReader.info("Validated authorized response: : " + response.getStatusLine());
	}

	@Given("Admin creates GET request for the user service API")
	public void admin_creates_get_request_for_the_user_service_api() {

		String testCaseId = "TC_02";
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		LoggerReader.info("authenticated without username and password");
		request = given().baseUri(configReader.getKeyValues("baseurl"));

	}

	@Then("Admin receives {int} Unauthorized Status with error message")
	public void admin_receives_unauthorized_status_with_error_message(Integer int1) {

		response.then().statusCode(currentTestData.getExpectedStatusCode())
				.statusLine(currentTestData.getExpectedStatusLine())
				.contentType(currentTestData.getExpectedContentType());
		LoggerReader.info("Validated unauthorized response: " + response.getStatusLine());

	}

	@Given("Admin creates GET request for the user service API with invalid base auth")
	public void admin_creates_get_request_for_the_user_service_api_with_invalid_base_auth() {

		String testCaseId = "TC_03";
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		LoggerReader.info("authenticated with invalid username and password");
		request = given().baseUri(configReader.getKeyValues("baseurl"));
	}

	@When("Admin sends HTTPS request with invalid end point")
	public void admin_sends_https_request_with_invalid_end_point() {

		String testCaseId = "TC_04";
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		response = request.request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader.info("Sent GET request with invalid endpoint: " + response.getStatusLine());
	}

	@Then("Admin receives {int} Not Found Status with error message")
	public void admin_receives_not_found_status_with_error_message(Integer int1) {

		response.then().statusCode(currentTestData.getExpectedStatusCode())
				.statusLine(currentTestData.getExpectedStatusLine())
				.contentType(currentTestData.getExpectedContentType());
		LoggerReader.info("Validated response: " + response.getStatusLine());

	}

	@Given("Admin creates PUT request for the user service API with baseAuth")
	public void admin_creates_put_request_for_the_user_service_api_with_base_auth() {

		String testCaseId = "TC_05";
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		LoggerReader.info("authenticated with valid username and password");
		request = given().baseUri(configReader.getKeyValues("baseurl"));

	}

	@When("Admin sends HTTPS request with invalid method")
	public void admin_sends_https_request_with_invalid_method() {

		response = request.request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader.info("Sent GET request with invalid Method name: " + response.getStatusLine());
	}

	@Then("Admin receives {int} Method Not Allowed Status with error message")
	public void admin_receives_method_not_allowed_status_with_error_message(Integer int1) {

		// response.then().statusCode(405).statusLine("HTTP/1.1 405 Method Not
		// Allowed").contentType("application/json");
		response.then().statusCode(currentTestData.getExpectedStatusCode())
				.statusLine(currentTestData.getExpectedStatusLine())
				.contentType(currentTestData.getExpectedContentType());
		LoggerReader.info("Validated response: " + response.getStatusLine());

	}

}

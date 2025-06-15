package api_stepDefinition;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import Utilities.JSONDataReader;
import Utilities.LoggerReader;
import Utilities.configReader;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.testCaseData;

public class GETByUserID_SD {

	RequestSpecification request;
	Response response;
	int userId = Post_SD.userId;
	String firstName = Post_SD.firstName;
	private testCaseData currentTestData;
	private static final String jsondatapath = "src/test/resources/apitestdata.json";

	@Given("Admin creates GET request for user service API")
	public void admin_creates_get_request_for_user_service_api() {
		String testCaseId = "TC_35";
		LoggerReader.info("User ID: " + userId);
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		LoggerReader.info("authenticated without username and password");
		request = given().baseUri(configReader.getKeyValues("baseurl")).pathParam("id", userId);
	}

	@When("Admin sends HTTPS Request with valid user Id")
	public void admin_sends_https_request_with_valid_user_id() {

		response = request.request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader.info("Sent GET by UserID request with noAuth: " + response.getStatusLine());
	}

	@Then("Admin receives Status Code {int} Unauthorized with error message in Response Body")
	public void admin_receives_status_code_unauthorized_with_error_message_in_response_body(Integer int1) {

		response.then().statusCode(currentTestData.getExpectedStatusCode())
				.statusLine(currentTestData.getExpectedStatusLine())
				.contentType(currentTestData.getExpectedContentType());
		LoggerReader.info("Validated unauthorized response: " + response.getStatusLine());
	}

	@Given("Admin creates GET request for user service API with invalid base auth")
	public void admin_creates_get_request_for_user_service_api_with_invalid_base_auth() {

		LoggerReader.info("User ID: " + userId);
		String testCaseId = "TC_36";
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		LoggerReader.info("authenticated with invalid username and password");
		request = given().baseUri(configReader.getKeyValues("baseurl")).pathParam("id", userId);

	}

	@When("Admin sends HTTPS Request with invalid user Id")
	public void admin_sends_https_request_with_invalid_user_id() {

		String testCaseId = "TC_37";
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		response = request.request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader.info("Sent GET by UserID request with invalid user Id and with Auth: " + response.getStatusLine());
	}

	@Then("Admin receives Status Code {int}  with error message in Response Body")
	public void admin_receives_status_code_with_error_message_in_response_body(Integer int1) {

		response.then().statusCode(currentTestData.getExpectedStatusCode())
				.statusLine(currentTestData.getExpectedStatusLine())
				.contentType(currentTestData.getExpectedContentType());
		LoggerReader.info("Validated authorized response: " + response.getStatusLine());

	}

	@Given("Admin creates PUT request for user service API")
	public void admin_creates_put_request_for_user_service_api() {

		String testCaseId = "TC_38";
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		LoggerReader.info("authenticated with username and password");
		request = given().baseUri(configReader.getKeyValues("baseurl")).pathParam("id", 24882);
	}

	@When("Admin sends HTTPS Request with invalid method")
	public void admin_sends_https_request_with_invalid_method() {

		response = request.request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader.info("Sent GET request with invalid Method name: " + response.getStatusLine());
	}

	@Then("Admin receives {int} Method Not Allowed with error message")
	public void admin_receives_method_not_allowed_with_error_message(Integer int1) {

		response.then().statusCode(currentTestData.getExpectedStatusCode())
				.statusLine(currentTestData.getExpectedStatusLine())
				.contentType(currentTestData.getExpectedContentType());
		LoggerReader.info("Validated response: " + response.getStatusLine());
	}

	@Given("Admin creates GET request for user service API with auth")
	public void admin_creates_get_request_for_user_service_api_with_auth() {

		LoggerReader.info("User ID: " + userId);
		String testCaseId = "TC_39";
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		LoggerReader.info("authenticated with username and password");
		request = given().baseUri(configReader.getKeyValues("baseurl")).pathParam("id", userId);
	}

	@When("Admin sends GET HTTPS Request with valid user Id")
	public void admin_sends_get_https_request_with_valid_user_id() {

		response = request.request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader.info("Sent GET request with baseAuth: " + response.getStatusLine());
	}

	@Then("Admin receives Status Code {int} OK with Response Body")
	public void admin_receives_status_code_ok_with_response_body(Integer int1) {

		response.then().statusCode(currentTestData.getExpectedStatusCode())
				.statusLine(currentTestData.getExpectedStatusLine())
				.contentType(currentTestData.getExpectedContentType()).body("userId", equalTo(userId))
				.body("userFirstName", equalTo(firstName)).body("userId", instanceOf(Number.class));
		LoggerReader.info("Validated response body and status line: " + response.getStatusLine());
	}

}

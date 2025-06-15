package api_stepDefinition;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import Utilities.JSONDataReader;
import Utilities.LoggerReader;
import Utilities.configReader;
import Utilities.passValues;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.testCaseData;

public class GETByFirstName {

	RequestSpecification request;
	Response response;
	int userId = Post_SD.userId;
	String firstName = Post_SD.firstName;

	private testCaseData currentTestData;
	private static final String jsondatapath = "src/test/resources/apitestdata.json";

	@Given("Admin creates GET request with first name for user service API")
	public void admin_creates_get_request_with_first_name_for_user_service_api() {

		String testCaseId = "TC_40";
		LoggerReader.info("First name: " + firstName);
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		LoggerReader.info("authenticated without username and password");
		request = given().baseUri(configReader.getKeyValues("baseurl")).pathParam("userFirstName", firstName);
	}

	@When("Admin sends HTTPS Request with valid user first name")
	public void admin_sends_https_request_with_valid_user_first_name() {

		response = request.request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader.info("Sent GET by First Name request with noAuth: " + response.getStatusLine());
	}

	@Then("Admin receives Status Code {int} Unauthorized with error message")
	public void admin_receives_status_code_unauthorized_with_error_message(Integer int1) {

		response.then().statusCode(currentTestData.getExpectedStatusCode())
				.statusLine(currentTestData.getExpectedStatusLine())
				.contentType(currentTestData.getExpectedContentType());
		LoggerReader.info("Validated unauthorized response: " + response.getStatusLine());
	}

	@Given("Admin creates GET request with first name for user service API with invalid base auth")
	public void admin_creates_get_request_with_first_name_for_user_service_api_with_invalid_base_auth() {

		String testCaseId = "TC_41";
		LoggerReader.info("First name: " + firstName);
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		LoggerReader.info("authenticated with invalid username and password");
		request = given().baseUri(configReader.getKeyValues("baseurl")).pathParam("userFirstName", firstName);

	}

	@Then("Admin receives Status Code {int} Unauthorized with error message with invalid auth")
	public void admin_receives_status_code_unauthorized_with_error_message_with_invalid_auth(Integer int1) {

		response.then().statusCode(currentTestData.getExpectedStatusCode())
				.statusLine(currentTestData.getExpectedStatusLine())
				.contentType(currentTestData.getExpectedContentType());
		LoggerReader.info("Validated unauthorized response: " + response.getStatusLine());
	}

	@Given("Admin creates GET request with first name for user service API with auth")
	public void admin_creates_get_request_with_first_name_for_user_service_api_with_auth() {

		LoggerReader.info("First name: " + firstName);
		String testCaseId = "TC_42";
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		LoggerReader.info("authenticated with username and password");
		request = given().baseUri(configReader.getKeyValues("baseurl")).pathParam("userFirstName", firstName);
	}

	@Then("Admin receives Status Code {int} OK with Response Body with auth")
	public void admin_receives_status_code_ok_with_response_body_with_auth(Integer int1) {

		System.out.println(response.getBody().asPrettyString());
		response.then().statusCode(currentTestData.getExpectedStatusCode())
				.statusLine(currentTestData.getExpectedStatusLine())
				.contentType(currentTestData.getExpectedContentType());
		
		LoggerReader.info("Validated authorized response: " + response.getStatusLine());
	}

}

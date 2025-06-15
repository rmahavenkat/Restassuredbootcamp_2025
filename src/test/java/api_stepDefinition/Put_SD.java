package api_stepDefinition;

import static io.restassured.RestAssured.given;

import Utilities.JSONDataReader;
import Utilities.LoggerReader;
import Utilities.configReader;
import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.testCaseData;
import static org.hamcrest.Matchers.*;

public class Put_SD {

	RequestSpecification request;
	Response response;
	int userId = Post_SD.userId;
	String firstName = Post_SD.firstName;
	private testCaseData currentTestData;
	private static final String jsondatapath = "src/test/resources/apitestdata.json";

	@Given("user creates PUT request with base url and valid endpoint with noauth")
	public void user_creates_put_request_with_base_url_and_valid_endpoint_with_noauth() {

		String testCaseId = "TC_43";
		LoggerReader.info("User ID: " + userId);
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		LoggerReader.info("authenticated without username and password");
		request = given().baseUri(configReader.getKeyValues("baseurl")).pathParam("userId", userId);

	}

	@When("user sends Request with valid user Id with Request Body")
	public void user_sends_request_with_valid_user_id_with_request_body() {

		response = request.request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader.info("Sent PUT by UserID request with noAuth: " + response.getStatusLine());
	}

	@Then("user receives {int} Error: Unauthorised Status with response body")
	public void user_receives_error_unauthorised_status_with_response_body(Integer int1) {

		response.then().statusCode(currentTestData.getExpectedStatusCode())
				.statusLine(currentTestData.getExpectedStatusLine())
				.contentType(currentTestData.getExpectedContentType());
		LoggerReader.info("Validated unauthorized response: " + response.getStatusLine());
	}

	@Given("user creates PUT request with base url and valid endpoint with auth")
	public void user_creates_put_request_with_base_url_and_valid_endpoint_with_auth() {

		String testCaseId = "TC_44";
		LoggerReader.info("User ID: " + userId);
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		LoggerReader.info("authenticated with username and password");
		request = given().baseUri(configReader.getKeyValues("baseurl")).pathParam("userId", userId);
	}

	@When("user sends Request with valid user Id with all fields empty in Request Body")
	public void user_sends_request_with_valid_user_id_with_all_fields_empty_in_request_body() {

		response = request.request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader.info("Sent PUT by UserID request with Auth: " + response.getStatusLine());
	}

	@Then("user receives {int} Error: Bad Request Status with all fields empty response body")
	public void user_receives_error_bad_request_status_with_all_fields_empty_response_body(Integer int1) {

		response.then().statusCode(currentTestData.getExpectedStatusCode())
				.statusLine(currentTestData.getExpectedStatusLine())
				.contentType(currentTestData.getExpectedContentType());
		LoggerReader.info("Validated authorized response: " + response.getStatusLine());
	}

	@Given("user creates PUT request with base url and valid endpoint")
	public void user_creates_put_request_with_base_url_and_valid_endpoint() {

		String testCaseId = "TC_45";
		LoggerReader.info("User ID: " + userId);
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		LoggerReader.info("authenticated without username and password");
		request = given().baseUri(configReader.getKeyValues("baseurl")).pathParam("userId", userId);

	}

	@When("user sends Request with numbers and Special characters in First Name in Request Body")
	public void user_sends_request_with_numbers_and_special_characters_in_first_name_in_request_body() {

		response = request.request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader.info("Sent PUT by UserID request with Auth: " + response.getStatusLine());

	}

	@Then("user receives {int} Error: Bad Request Status empty response body")
	public void user_receives_error_bad_request_status_empty_response_body(Integer int1) {

		response.then().statusCode(currentTestData.getExpectedStatusCode())
				.statusLine(currentTestData.getExpectedStatusLine())
				.contentType(currentTestData.getExpectedContentType());
		LoggerReader.info("Validated authorized response: " + response.getStatusLine());
	}

	@Given("user creates PUT request with base url and valid endpoints")
	public void user_creates_put_request_with_base_url_and_valid_endpoints() {

		String testCaseId = "TC_46";
		LoggerReader.info("User ID: " + userId);
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		LoggerReader.info("authenticated without username and password");
		request = given().baseUri(configReader.getKeyValues("baseurl")).pathParam("userId", userId);
	}

	@When("user sends Request with numbers and Special characters in Last Name in Request Body")
	public void user_sends_request_with_numbers_and_special_characters_in_last_name_in_request_body() {

		response = request.request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader.info("Sent PUT by UserID request with Auth: " + response.getStatusLine());
	}

	@Then("user receives {int} Error: Bad Request Status in response body")
	public void user_receives_error_bad_request_status_in_response_body(Integer int1) {

		response.then().statusCode(currentTestData.getExpectedStatusCode())
				.statusLine(currentTestData.getExpectedStatusLine())
				.contentType(currentTestData.getExpectedContentType());
		LoggerReader.info("Validated authorized response: " + response.getStatusLine());
	}

	@Given("user creates PUT request with base url and valid end point")
	public void user_creates_put_request_with_base_url_and_valid_end_point() {

		String testCaseId = "TC_47";
		LoggerReader.info("User ID: " + userId);
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		LoggerReader.info("authenticated without username and password");
		request = given().baseUri(configReader.getKeyValues("baseurl")).pathParam("userId", userId);
	}

	@When("user sends Request with More than {int} character of Phone number in Request Body")
	public void user_sends_request_with_more_than_character_of_phone_number_in_request_body(Integer int1) {

		response = request.request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader.info("Sent PUT by UserID request with Auth: " + response.getStatusLine());

	}

	@Then("user receives {int} Bad Request Status in response body")
	public void user_receives_bad_request_status_in_response_body(Integer int1) {

		response.then().statusCode(currentTestData.getExpectedStatusCode())
				.statusLine(currentTestData.getExpectedStatusLine())
				.contentType(currentTestData.getExpectedContentType());
		LoggerReader.info("Validated authorized response: " + response.getStatusLine());

	}

	@When("user sends Request with Alphabets in Phone number field in Request Body")
	public void user_sends_request_with_alphabets_in_phone_number_field_in_request_body() {

		String testCaseId = "TC_48";
		LoggerReader.info("User ID: " + userId);
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		response = request.request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader.info("Sent PUT by UserID request with Auth: " + response.getStatusLine());
	}

	@Then("user receives {int} Bad Request in response body")
	public void user_receives_bad_request_in_response_body(Integer int1) {

		response.then().statusCode(currentTestData.getExpectedStatusCode())
				.statusLine(currentTestData.getExpectedStatusLine())
				.contentType(currentTestData.getExpectedContentType());
		LoggerReader.info("Validated authorized response: " + response.getStatusLine());
	}

	@Given("user creates PUT request with base url and valid endpoint with valid user id")
	public void user_creates_put_request_with_base_url_and_valid_endpoint_with_valid_user_id() {

		String testCaseId = "TC_49";
		LoggerReader.info("User ID: " + userId);
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		LoggerReader.info("authenticated without username and password");
		request = given().baseUri(configReader.getKeyValues("baseurl")).pathParam("userId", userId);

	}

	@When("user sends Request with valid user Id and all updated fileds in Request Body")
	public void user_sends_request_with_valid_user_id_and_all_updated_fileds_in_request_body() {

		response = request.header("Content-Type", "application/json").body(currentTestData).request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader.info("Sent PUT by UserID request with Auth: " + response.getStatusLine());

	}

	@Then("user receives {int} OK Request in response body")
	public void user_receives_ok_request_in_response_body(Integer int1) {

		response.then().statusCode(currentTestData.getExpectedStatusCode())
				.statusLine(currentTestData.getExpectedStatusLine())
				.contentType(currentTestData.getExpectedContentType());
		LoggerReader.info("Validated authorized response: " + response.getStatusLine());

	}

}

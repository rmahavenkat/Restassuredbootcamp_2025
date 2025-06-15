package api_stepDefinition;

import static io.restassured.RestAssured.given;

import Utilities.JSONDataReader;
import Utilities.LoggerReader;
import Utilities.configReader;
import Utilities.passValues;
import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.testCaseData;
import static org.hamcrest.Matchers.*;

public class Post_SD {

	private passValues passvalues;
	RequestSpecification request;
	Response response;
	public static int userId;
	static String firstName;
	private testCaseData currentTestData;
	private static final String jsondatapath = "src/test/resources/apitestdata.json";
	
	public Post_SD(passValues passvalues) {
        this.passvalues = passvalues;
    }

	@Given("User sets base URL and Valid endpoints")
	public void user_sets_base_url_and_valid_endpoints() {
		String testCaseId = "TC_06";
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		LoggerReader.info("authenticated without username and password");
		request = given().baseUri(configReader.getKeyValues("baseurl"));

	}

	@When("User sends POST request with request body without authorization")
	public void user_sends_post_request_with_request_body_without_authorization() {

		request = request.contentType(ContentType.JSON).body(currentTestData);

		response = request.request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader.info("Sent POST request without auth: " + response.getStatusLine());
	}

	@Then("User receives {int} Unauthorized")
	public void user_receives_unauthorized(Integer int1) {

		response.then().statusCode(currentTestData.getExpectedStatusCode())
				.statusLine(currentTestData.getExpectedStatusLine())
				.contentType(currentTestData.getExpectedContentType());
		LoggerReader.info("Validated unauthorized response: " + response.getStatusLine());
	}

	@Given("User sets invalid base URL and Valid endpoints")
	public void user_sets_invalid_base_url_and_valid_endpoints() {

		String testCaseId = "TC_07";
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		LoggerReader.info("authenticated with valid username and password");
		request = given().baseUri(configReader.getKeyValues("invalidbaseurl"));

	}

	@When("User sends POST request with all fields in request body")
	public void user_sends_post_request_with_all_fields_in_request_body() {

		request = request.contentType(ContentType.JSON).body(currentTestData);
		response = request.request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader.info("Sent POST request with auth: " + response.getStatusLine());

	}

	@Then("User receives {int} Not found status with message")
	public void user_receives_not_found_status_with_message(Integer int1) {

		response.then().statusCode(currentTestData.getExpectedStatusCode())
				.statusLine(currentTestData.getExpectedStatusLine())
				.contentType(currentTestData.getExpectedContentType());
		LoggerReader.info("Validated authorized response: " + response.getStatusLine());
	}

	@Given("User sets base URL and invalid endpoints")
	public void user_sets_base_url_and_invalid_endpoints() {

		String testCaseId = "TC_08";
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		LoggerReader.info("authenticated with valid username and password");
		request = given().baseUri(configReader.getKeyValues("baseurl"));
	}

	@When("User sends POST request with all fields in request body with invalid endpoint")
	public void user_sends_post_request_with_all_fields_in_request_body_with_invalid_endpoint() {

		request = request.contentType(ContentType.JSON).body(currentTestData);
		response = request.request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader.info("Sent POST request with invalid endpoints: " + response.getStatusLine());

	}

	@When("User sends POST request with non mandetory fields in request body")
	public void user_sends_post_request_with_non_mandetory_fields_in_request_body() {
		String testCaseId = "TC_09";
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		request = request.contentType(ContentType.JSON).body(currentTestData);
		response = request.request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader.info("Sent POST request with non mandetory fields: " + response.getStatusLine());
	}

	@Then("User receives {int} Bad Requeststatus with message")
	public void user_receives_bad_requeststatus_with_message(Integer int1) {

		response.then().statusCode(currentTestData.getExpectedStatusCode())
				.statusLine(currentTestData.getExpectedStatusLine())
				.contentType(currentTestData.getExpectedContentType());
		LoggerReader.info("Validated response: " + response.getStatusLine());
	}

	@When("User sends POST request with all fields empty in request body")
	public void user_sends_post_request_with_all_fields_empty_in_request_body() {

		String testCaseId = "TC_10";
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		request = request.contentType(ContentType.JSON).body(currentTestData);
		response = request.request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader.info("Sent POST request with all fields empty: " + response.getStatusLine());
	}

	
	@When("User sends POST request with numbers in first name in request body")
	public void user_sends_post_request_with_numbers_and_special_characters_in_first_name_in_request_body() {

		String testCaseId = "TC_11";
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		request = request.contentType(ContentType.JSON).body(currentTestData);
		response = request.request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader.info("Sent POST request with numbers in first name in request body : " + response.getStatusLine());

	}

	@When("User sends POST request with special characters in first name in request body")
	public void user_sends_post_request_with_special_characters_in_first_name_in_request_body() {

		String testCaseId = "TC_12";
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		request = request.contentType(ContentType.JSON).body(currentTestData);
		response = request.request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader.info("Sent POST request with special characters in first name in request body : "
				+ response.getStatusLine());

	}

	@When("User sends POST request with numbers in last name in request body")
	public void user_sends_post_request_with_numbers_in_last_name_in_request_body() {

		String testCaseId = "TC_13";
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		request = request.contentType(ContentType.JSON).body(currentTestData);
		response = request.request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader.info("Sent POST request with numbers in last name in request body : " + response.getStatusLine());
	}

	@When("User sends POST request with special characters in Last name in request body")
	public void user_sends_post_request_with_special_characters_in_last_name_in_request_body() {

		String testCaseId = "TC_14";
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		request = request.contentType(ContentType.JSON).body(currentTestData);
		response = request.request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader.info("Sent POST request with special characters  in last name in request body : "
				+ response.getStatusLine());
	}

	@When("User sends POST request with alphabets in contact number in request body")
	public void user_sends_post_request_with_alphabets_in_contact_number_in_request_body() {

		String testCaseId = "TC_15";
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		request = request.contentType(ContentType.JSON).body(currentTestData);
		response = request.request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader.info(
				"Sent POST request with alphabets in contact number in request body : " + response.getStatusLine());
	}

	@When("User sends POST request with special characters in contact number in request body")
	public void user_sends_post_request_with_special_characters_in_contact_number_in_request_body() {

		String testCaseId = "TC_16";
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		request = request.contentType(ContentType.JSON).body(currentTestData);
		response = request.request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader.info("Sent POST request with special characters  in contact number in request body : "
				+ response.getStatusLine());
	}

	@When("User sends POST request with less than {int} characters in contact number in request body")
	public void user_sends_post_request_with_less_than_characters_in_contact_number_in_request_body(Integer int1) {

		String testCaseId = "TC_17";
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		request = request.contentType(ContentType.JSON).body(currentTestData);
		response = request.request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader.info("Sent POST request with special characters  in contact number in request body : "
				+ response.getStatusLine());
	}

	@When("User sends POST request with more than {int} characters in contact number in request body")
	public void user_sends_post_request_with_more_than_characters_in_contact_number_in_request_body(Integer int1) {

		String testCaseId = "TC_18";
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		request = request.contentType(ContentType.JSON).body(currentTestData);
		response = request.request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader.info("Sent POST request with special characters  in contact number in request body : "
				+ response.getStatusLine());

	}

	@When("User sends POST request with invalid email format in request body")
	public void user_sends_post_request_with_invalid_email_format_in_request_body() {

		String testCaseId = "TC_19";
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		request = request.contentType(ContentType.JSON).body(currentTestData);
		response = request.request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader.info("Sent POST request with invalid email format in request body : " + response.getStatusLine());
	}

	@When("User sends POST request with special characters in email id in request body")
	public void user_sends_post_request_with_special_characters_in_email_id_in_request_body() {

		String testCaseId = "TC_20";
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		request = request.contentType(ContentType.JSON).body(currentTestData);
		response = request.request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader.info(
				"Sent POST request with special characters in email id in request body : " + response.getStatusLine());
	}

	@When("User sends POST request with number in email id in request body")
	public void user_sends_post_request_with_number_in_email_id_in_request_body() {

		String testCaseId = "TC_21";
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		request = request.contentType(ContentType.JSON).body(currentTestData);
		response = request.request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader.info("Sent POST request with number in email id in request body : " + response.getStatusLine());

	}

	@When("User sends POST request with plot number contains integer in request body")
	public void user_sends_post_request_with_plot_number_contains_integer_in_request_body() {

		String testCaseId = "TC_22";
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		request = request.contentType(ContentType.JSON).body(currentTestData);
		response = request.request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader
				.info("Sent POST request with integer in plot number in request body : " + response.getStatusLine());
	}

	@When("User sends POST request with plot number contains special characters in request body")
	public void user_sends_post_request_with_plot_number_contains_special_characters_in_request_body() {

		String testCaseId = "TC_23";
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		request = request.contentType(ContentType.JSON).body(currentTestData);
		response = request.request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader.info("Sent POST request with special characters in plot number in request body : "
				+ response.getStatusLine());

	}

	@When("User sends POST request with Street contains integer in request body")
	public void user_sends_post_request_with_street_contains_integer_in_request_body() {

		String testCaseId = "TC_24";
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		request = request.contentType(ContentType.JSON).body(currentTestData);
		response = request.request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader
				.info("Sent POST request with Street contains integer in request body : " + response.getStatusLine());

	}

	@When("User sends POST request with Street contains special characters in request body")
	public void user_sends_post_request_with_street_contains_special_characters_in_request_body() {

		String testCaseId = "TC_25";
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		request = request.contentType(ContentType.JSON).body(currentTestData);
		response = request.request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader.info("Sent POST request with Street contains special characters in request body : "
				+ response.getStatusLine());

	}

	@When("User sends POST request with State contains integer in request body")
	public void user_sends_post_request_with_state_contains_integer_in_request_body() {

		String testCaseId = "TC_26";
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		request = request.contentType(ContentType.JSON).body(currentTestData);
		response = request.request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader
				.info("Sent POST request with State contains integer in request body : " + response.getStatusLine());
	}

	@When("User sends POST request with State contains special characters in request body")
	public void user_sends_post_request_with_state_contains_special_characters_in_request_body() {

		String testCaseId = "TC_27";
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		request = request.contentType(ContentType.JSON).body(currentTestData);
		response = request.request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader.info("Sent POST request with State contains specialcharacters in request body : "
				+ response.getStatusLine());

	}

	@When("User sends POST request with country contains integer in request body")
	public void user_sends_post_request_with_country_contains_integer_in_request_body() {

		String testCaseId = "TC_28";
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		request = request.contentType(ContentType.JSON).body(currentTestData);
		response = request.request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader
				.info("Sent POST request with country contains integer in request body : " + response.getStatusLine());

	}

	@When("User sends POST request with country contains special characters in request body")
	public void user_sends_post_request_with_country_contains_special_characters_in_request_body() {

		String testCaseId = "TC_29";
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		request = request.contentType(ContentType.JSON).body(currentTestData);
		response = request.request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader.info("Sent POST request with country contains special characters in request body : "
				+ response.getStatusLine());

	}

	@When("User sends POST request with zipcode contains alphabet in request body")
	public void user_sends_post_request_with_zipcode_contains_alphabet_in_request_body() {

		String testCaseId = "TC_30";
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		request = request.contentType(ContentType.JSON).body(currentTestData);
		response = request.request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader
				.info("Sent POST request with zipcode contains alphabet in request body : " + response.getStatusLine());

	}

	@When("User sends POST request with zipcode contains special characters in request body")
	public void user_sends_post_request_with_zipcode_contains_special_characters_in_request_body() {

		String testCaseId = "TC_31";
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		request = request.contentType(ContentType.JSON).body(currentTestData);
		response = request.request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader.info("Sent POST request with zipcode contains special characters in request body : "
				+ response.getStatusLine());

	}

	@When("User sends POST request with all valid fields in request body")
	public void user_sends_post_request_with_all_valid_fields_in_request_body() {

		String testCaseId = "TC_32";
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		request = request.contentType(ContentType.JSON).body(currentTestData);
		response = request.request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader.info("Sent POST request with all valid fields in request body : " + response.getStatusLine());

	}

	@Then("New User created with status code {int} Created")
	public void new_user_created_with_status_code_created(Integer int1) {

		response.then()
		        .statusCode(currentTestData.getExpectedStatusCode())
				.statusLine(currentTestData.getExpectedStatusLine())
				.contentType(currentTestData.getExpectedContentType())
				// checking response data validation
				.body("userFirstName", equalTo(currentTestData.getUserFirstName()))
				.body("userLastName", equalTo(currentTestData.getUserLastName()))
				.body("userContactNumber", equalTo(Long.valueOf(currentTestData.getUserContactNumber())))
				.body("userEmailId", equalTo(currentTestData.getUserEmailId()))
				.body("userAddress.plotNumber", equalTo(currentTestData.getUserAddress().getPlotNumber()))
				.body("userAddress.street", equalTo(currentTestData.getUserAddress().getStreet()))
				.body("userAddress.state", equalTo(currentTestData.getUserAddress().getState()))
				.body("userAddress.country", equalTo(currentTestData.getUserAddress().getCountry()))
				.body("userAddress.zipCode", equalTo(Integer.valueOf(currentTestData.getUserAddress().getZipCode())))
				//data type validation
				.body("userFirstName", instanceOf(String.class))
				.body("userLastName", instanceOf(String.class))
				.body("userContactNumber", instanceOf(Number.class))
				.body("userEmailId", instanceOf(String.class))
				.body("userAddress.plotNumber", instanceOf(String.class))
				.body("userAddress.street", instanceOf(String.class))
				.body("userAddress.state", instanceOf(String.class))
				.body("userAddress.country", instanceOf(String.class))
				.body("userAddress.zipCode", instanceOf(Number.class));

		LoggerReader.info("Validated authorized response: " + response.getStatusLine());
		 userId = response.path("userId");
		 firstName = response.path("userFirstName").toString();
		 
		 passvalues.getuserData().setUserId(userId);
		 passvalues.getuserData().setUserFirstName(firstName);
		LoggerReader.info("User ID: " + userId);
		LoggerReader.info("First Name: " + firstName);

	}
	
	@When("User sends POST request with existing contact number in request body")
	public void user_sends_post_request_with_existing_contact_number_in_request_body() {

		String testCaseId = "TC_33";
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		request = request.contentType(ContentType.JSON).body(currentTestData);
		response = request.request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader
				.info("Sent POST request with existing contact number in request body : " + response.getStatusLine());

	}

	@Then("User receives {int} Conflict status with message")
	public void user_receives_conflict_status_with_message(Integer int1) {

		response.then().statusCode(currentTestData.getExpectedStatusCode())
				.statusLine(currentTestData.getExpectedStatusLine())
				.contentType(currentTestData.getExpectedContentType());
		LoggerReader.info("Validated response: " + response.getStatusLine());

	}

	@When("User sends POST request with existing email id in request body")
	public void user_sends_post_request_with_existing_email_id_in_request_body() {

		String testCaseId = "TC_34";
		currentTestData = JSONDataReader.getAllTestCase(jsondatapath, testCaseId);
		request = request.contentType(ContentType.JSON).body(currentTestData);
		response = request.request(currentTestData.getMethod(), currentTestData.getEndpoint());
		LoggerReader
				.info("Sent POST request with existing email id number in request body : " + response.getStatusLine());
	}


}

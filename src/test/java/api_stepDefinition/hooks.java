package api_stepDefinition;


import Utilities.LoggerReader;
import Utilities.configReader;
import io.cucumber.java.Before;
import io.restassured.RestAssured;

public class hooks {
	private static final String validUsername = configReader.getKeyValues("username");
    private static final String validPassword = configReader.getKeyValues("password");
    private static final String invalidUsername = configReader.getKeyValues("invalidusername");
    private static final String invalidPassword = configReader.getKeyValues("invalidpassword");

	@Before("@auth")
	public void setupBaseAuth(){
		LoggerReader.info("Setting valid basic auth");
		RestAssured.authentication = RestAssured.preemptive().basic(validUsername, validPassword);
	}
	@Before("@invalidauth")
	public void setupinvalidBaseAuth(){
		LoggerReader.info("Setting invalid basic auth");
		RestAssured.authentication = RestAssured.preemptive().basic(invalidUsername, invalidPassword);
	}
	
	
	@Before("@noauth")
	public void setupNoAuth(){
		LoggerReader.info("No authentication for this scenario");
		RestAssured.authentication =RestAssured.DEFAULT_AUTH;
	}
}

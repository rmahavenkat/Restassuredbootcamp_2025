@getByFirstname
Feature: creating new users

  Background: Admin sets up the base URI for the user service API

   @TC_40 @noauth
  Scenario: Check if Admin able to retrieve user details with valid user first name and without authorization
    Given Admin creates GET request with first name for user service API
    When  Admin sends HTTPS Request with valid user first name
    Then Admin receives Status Code 401 Unauthorized with error message
    
    @TC_41 @invalidauth
  Scenario: Check if Admin able to retrieve user details with  valid user first name and invalid authorization
    Given Admin creates GET request with first name for user service API with invalid base auth
    When  Admin sends HTTPS Request with valid user first name
    Then Admin receives Status Code 401 Unauthorized with error message with invalid auth
    
    @TC_42 @auth
  Scenario: Check if Admin able to retrieve user details with  valid authorization and valid user first name
    Given Admin creates GET request with first name for user service API with auth
    When Admin sends HTTPS Request with valid user first name
    Then Admin receives Status Code 200 OK with Response Body with auth  
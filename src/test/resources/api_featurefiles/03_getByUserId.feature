
@getByUserId
Feature: creating new users

  Background: Admin sets up the base URI for the user service API

   @TC_35 @noauth
  Scenario: Check if Admin able to retrieve user details with  valid user Id and without authorization
    Given Admin creates GET request for user service API
    When Admin sends HTTPS Request with valid user Id
    Then Admin receives Status Code 401 Unauthorized with error message in Response Body
    
    @TC_36 @invalidauth
  Scenario: Check if Admin able to retrieve user details with  valid user Id and invalid authorization
    Given Admin creates GET request for user service API with invalid base auth
    When Admin sends HTTPS Request with valid user Id
    Then Admin receives Status Code 401 Unauthorized with error message in Response Body
    
    @TC_37 @auth
  Scenario: Check if Admin able to retrieve user details with  valid authorization and invalid user Id
    Given Admin creates GET request for user service API
    When Admin sends HTTPS Request with invalid user Id
    Then Admin receives Status Code 400  with error message in Response Body
    
    @TC_38 @auth
  Scenario: Check if Admin able to retrieve user details with  valid user Id and invalid method
    Given Admin creates PUT request for user service API
    When Admin sends HTTPS Request with invalid method
    Then Admin receives 405 Method Not Allowed with error message
    
    @TC_39 @auth
  Scenario: Check if Admin able to retrieve user details with  valid authorization and valid user Id
    Given Admin creates GET request for user service API with auth
    When Admin sends GET HTTPS Request with valid user Id
    Then Admin receives Status Code 200 OK with Response Body 

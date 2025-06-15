@getallusersScenario
Feature: get all users

  Background: Admin sets up the base URI for the user service API

  @TC_01 @auth
  Scenario: Check if Admin able to retreive all user details with valid end point and with authorization
    Given Admin creates GET request for the user service API with baseAuth
    When Admin sends HTTPS request with valid end point
    Then Admin receives 200 OK Status with response body

  @TC_02 @noauth
  Scenario: Check if Admin able to retreive all user details with valid end point and without authorization
    Given Admin creates GET request for the user service API
    When Admin sends HTTPS request with valid end point
    Then Admin receives 401 Unauthorized Status with error message

  @TC_03 @invalidauth
  Scenario: Check if Admin able to retreive all user details with valid end point and invalid authorization
    Given Admin creates GET request for the user service API with invalid base auth
    When Admin sends HTTPS request with valid end point
    Then Admin receives 401 Unauthorized Status with error message

  @TC_04 @auth
  Scenario: Check if Admin able to retreive all user details with invalid end point and valid authorization
    Given Admin creates GET request for the user service API with baseAuth
    When Admin sends HTTPS request with invalid end point
    Then Admin receives 404 Not Found Status with error message

  @TC_05 @auth
  Scenario: Check if Admin able to retreive all user details with valid end point and invalid method
    Given Admin creates PUT request for the user service API with baseAuth
    When Admin sends HTTPS request with invalid method
    Then Admin receives 405 Method Not Allowed Status with error message
    
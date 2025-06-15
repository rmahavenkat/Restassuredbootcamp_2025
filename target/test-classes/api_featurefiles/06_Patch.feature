@patch
Feature: updating the users with single field

  Background: Admin sets up the base URI for the user service API

  @TC_50 @noauth
  Scenario: Check if user able to update user details with No Authorization
    Given user creates PATCH request with base url and valid endpoint
    When user sends patch Request with valid user Id with Request Body
    Then user receives 401 Unauthorised Status with response body

  @TC_51 @auth
  Scenario:  Check if user able to update First Name with valid user id  
    Given user creates PATCH request with base url and valid endpoint with auth
    When user sends Request with valid user Id and updated First Name in Request Body 
    Then user receives 200 OK Status with response body
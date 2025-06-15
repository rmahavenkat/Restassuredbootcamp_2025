@post
Feature: updating the users

  Background: Admin sets up the base URI for the user service API

  @TC_43 @noauth
  Scenario: Check if user able to update user details with No Authorization
    Given user creates PUT request with base url and valid endpoint with noauth
    When user sends Request with valid user Id with Request Body
    Then user receives 401 Error: Unauthorised Status with response body

  @TC_44 @auth
  Scenario: Check if user able to update user details with user id and all fields empty
    Given user creates PUT request with base url and valid endpoint with auth
    When user sends Request with valid user Id with all fields empty in Request Body
    Then user receives 400 Error: Bad Request Status with all fields empty response body

  @TC_45 @auth
  Scenario: Check if user able to update First name with numbers and Special characters
    Given user creates PUT request with base url and valid endpoint
    When user sends Request with numbers and Special characters in First Name in Request Body
    Then user receives 400 Error: Bad Request Status empty response body

  @TC_46 @auth
  Scenario: Check if user able to update  Last name with numbers and Special characters
    Given user creates PUT request with base url and valid endpoints
    When user sends Request with numbers and Special characters in Last Name in Request Body
    Then user receives 400 Error: Bad Request Status in response body

  @TC_47 @auth
  Scenario: Check if user able to update Contact number with more than 10 character
    Given user creates PUT request with base url and valid end point
    When user sends Request with More than 10 character of Phone number in Request Body
    Then user receives 400 Bad Request Status in response body

  @TC_48 @auth
  Scenario: Check if user able to update user details with Alphabets for Contact number
    Given user creates PUT request with base url and valid endpoint
    When user sends Request with Alphabets in Phone number field in Request Body
    Then user receives 400 Bad Request in response body
    
    @TC_49 @auth
  Scenario:  Check if user able to update user details with valid user id  
    Given user creates PUT request with base url and valid endpoint with valid user id 
    When user sends Request with valid user Id and all updated fileds in Request Body 
    Then user receives 200 OK Request in response body

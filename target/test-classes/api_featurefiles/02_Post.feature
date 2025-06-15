@post
Feature: creating new users

  Background: Admin sets up the base URI for the user service API

  @TC_06 @noauth
  Scenario: Add New User with all fields without Authorization
    Given User sets base URL and Valid endpoints
    When User sends POST request with request body without authorization
    Then User receives 401 Unauthorized

  @TC_07 @auth
  Scenario: Add new user with invalid base url
    Given User sets invalid base URL and Valid endpoints
    When User sends POST request with all fields in request body
    Then User receives 404 Not found status with message

  @TC_08 @auth
  Scenario: Add new user with invalid end point
    Given User sets base URL and invalid endpoints
    When User sends POST request with all fields in request body with invalid endpoint
    Then User receives 404 Not found status with message

  @TC_09 @auth
  Scenario: Add new user with non mandetory fields only
    Given User sets base URL and Valid endpoints
    When User sends POST request with non mandetory fields in request body
    Then User receives 400 Bad Requeststatus with message

  @TC_10 @auth
  Scenario: Add new user with all fields empty
    Given User sets base URL and Valid endpoints
    When User sends POST request with all fields empty in request body
    Then User receives 400 Bad Requeststatus with message


  @TC_11 @auth
  Scenario: Add new user with interger values in first name
    Given User sets base URL and Valid endpoints
    When User sends POST request with numbers in first name in request body
    Then User receives 400 Bad Requeststatus with message

  @TC_12 @auth
  Scenario: Add new user with special characters in first name
    Given User sets base URL and Valid endpoints
    When User sends POST request with special characters in first name in request body
    Then User receives 400 Bad Requeststatus with message

  @TC_13 @auth
  Scenario: Add new user with interger values in Last name
    Given User sets base URL and Valid endpoints
    When User sends POST request with numbers in last name in request body
    Then User receives 400 Bad Requeststatus with message

  @TC_14 @auth
  Scenario: Add new user with special characters in first name
    Given User sets base URL and Valid endpoints
    When User sends POST request with special characters in Last name in request body
    Then User receives 400 Bad Requeststatus with message

  @TC_15 @auth
  Scenario: Add new user with alphabets in contact number
    Given User sets base URL and Valid endpoints
    When User sends POST request with alphabets in contact number in request body
    Then User receives 400 Bad Requeststatus with message

  @TC_16 @auth
  Scenario: Add new user with special characters in contact number
    Given User sets base URL and Valid endpoints
    When User sends POST request with special characters in contact number in request body
    Then User receives 400 Bad Requeststatus with message

  @TC_17 @auth
  Scenario: Add new user with less than 10 characters in contact number
    Given User sets base URL and Valid endpoints
    When User sends POST request with less than 10 characters in contact number in request body
    Then User receives 400 Bad Requeststatus with message

  @TC_18 @auth
  Scenario: Add new user with more than 10 characters in contact number
    Given User sets base URL and Valid endpoints
    When User sends POST request with more than 10 characters in contact number in request body
    Then User receives 400 Bad Requeststatus with message

  @TC_19 @auth
  Scenario: Add new user with invalid email format
    Given User sets base URL and Valid endpoints
    When User sends POST request with invalid email format in request body
    Then User receives 400 Bad Requeststatus with message

  @TC_20 @auth
  Scenario: Add new user with special characters in email id
    Given User sets base URL and Valid endpoints
    When User sends POST request with special characters in email id in request body
    Then User receives 400 Bad Requeststatus with message

  @TC_21 @auth
  Scenario: Add new user with number in email id
    Given User sets base URL and Valid endpoints
    When User sends POST request with number in email id in request body
    Then User receives 400 Bad Requeststatus with message

  @TC_22 @auth
  Scenario: Add new user with plot number contains interger values
    Given User sets base URL and Valid endpoints
    When User sends POST request with plot number contains integer in request body
    Then User receives 400 Bad Requeststatus with message

  @TC_23 @auth
  Scenario: Add new user with plot number contains special characters
    Given User sets base URL and Valid endpoints
    When User sends POST request with plot number contains special characters in request body
    Then User receives 400 Bad Requeststatus with message

  @TC_24 @auth
  Scenario: Add new user with Street contains interger values
    Given User sets base URL and Valid endpoints
    When User sends POST request with Street contains integer in request body
    Then User receives 400 Bad Requeststatus with message

  @TC_25 @auth
  Scenario: Add new user with Street contains special characters
    Given User sets base URL and Valid endpoints
    When User sends POST request with Street contains special characters in request body
    Then User receives 400 Bad Requeststatus with message

  @TC_26 @auth
  Scenario: Add new user with State contains interger values
    Given User sets base URL and Valid endpoints
    When User sends POST request with State contains integer in request body
    Then User receives 400 Bad Requeststatus with message

  @TC_27 @auth
  Scenario: Add new user with State contains special characters
    Given User sets base URL and Valid endpoints
    When User sends POST request with State contains special characters in request body
    Then User receives 400 Bad Requeststatus with message

  @TC_28 @auth
  Scenario: Add new user with country contains interger values
    Given User sets base URL and Valid endpoints
    When User sends POST request with country contains integer in request body
    Then User receives 400 Bad Requeststatus with message

  @TC_29 @auth
  Scenario: Add new user with country contains special characters
    Given User sets base URL and Valid endpoints
    When User sends POST request with country contains special characters in request body
    Then User receives 400 Bad Requeststatus with message

  @TC_30 @auth
  Scenario: Add new user with zipcode contains alphabet values
    Given User sets base URL and Valid endpoints
    When User sends POST request with zipcode contains alphabet in request body
    Then User receives 400 Bad Requeststatus with message

  @TC_31 @auth
  Scenario: Add new user with zipcode contains special characters
    Given User sets base URL and Valid endpoints
    When User sends POST request with zipcode contains special characters in request body
    Then User receives 400 Bad Requeststatus with message

  @TC_32 @auth
  Scenario: Add New User with all fields
    Given User sets base URL and Valid endpoints
    When User sends POST request with all valid fields in request body
    Then New User created with status code 201 Created
    
     @TC_33 @auth
  Scenario: Add new user with existing contact number
    Given User sets base URL and Valid endpoints
    When User sends POST request with existing contact number in request body
    Then User receives 409 Conflict status with message

  @TC_34 @auth
  Scenario: Add new user with existing email id
    Given User sets base URL and Valid endpoints
    When User sends POST request with existing email id in request body
    Then User receives 409 Conflict status with message
    

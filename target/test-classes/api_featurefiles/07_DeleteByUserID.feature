@deletebyuserID
Feature: delete the users with userID

  Background: Admin sets up the base URI for the user service API

  @TC_52 @auth
  Scenario: Delete operation with valid userID
    Given User sets the valid baseurl
    When User sends delete request with valid userID
    Then user receives 200:ok status

  @TC_53 @auth
  Scenario:  Delete operation with non existing userID
    Given User sets the valid baseurl with non existing userID
    When User sends delete request without non existing userID
    Then user receives status 404 NOT_FOUND
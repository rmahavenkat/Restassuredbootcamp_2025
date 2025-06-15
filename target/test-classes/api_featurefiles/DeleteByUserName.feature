@deletebyusername
Feature: delete the users with userName

  Background: Admin sets up the base URI for the user service API

  @TC_54 @auth
  Scenario: Delete operation with valid firstname
    Given User sets the valid baseurl with valid firstname
    When User sends delete request with valid first name
    Then user receives 200:ok status Success

  @TC_55 @auth
  Scenario:  Delete operation with non existing firstname
    Given User sets the valid baseurl with non existing username
    When User sends delete request without non existing username
    Then user receives status 404 NOT_FOUND message
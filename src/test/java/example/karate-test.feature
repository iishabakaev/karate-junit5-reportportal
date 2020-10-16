Feature: My First Test

  Background:
    * url jsonplaceholder
    * path '/posts'
    * configure headers = { 'Content-Type': 'application/json; charset=UTF-8' }

  Scenario: test action
    Given request read('requestBody.json')
    When method POST
    Then status 200
    And match response contains {"id": "101"}

Feature: employees can be retrieved
  Scenario: client makes call to GET /employee
    When the client calls /employee
    Then the client receives status code of 200
    And the client receives an array of employees
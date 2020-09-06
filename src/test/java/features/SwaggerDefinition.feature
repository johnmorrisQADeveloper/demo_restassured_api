Feature:
  Verify swagger.json endpoint

  Scenario: Verify correct swagger definitions
    When I perform GET operation for "/swagger.json"
    Then I should see below properties
      | swagger  | 2.0    |
      | basePath | /      |
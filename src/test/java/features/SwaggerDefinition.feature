Feature:
  Verify swagger.json endpoint

  Scenario: Verify correct swagger definitions
    Given I perform GET operation for "/swagger.json"
      Then I should see property "swagger" to be "2.0"
      Then I should see property "basePath" to be "/"
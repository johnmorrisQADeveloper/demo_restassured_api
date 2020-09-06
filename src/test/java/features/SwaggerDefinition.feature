Feature:
  Verify swagger definition endpoint

  Background:
    Given I perform GET operation for "/swagger.json"

    Scenario: Verify correct swagger version
      Then I should see "swagger" version to be "2.0"

    Scenario: Verify correct basePath
      Then I should see "basePath" version to be "/"

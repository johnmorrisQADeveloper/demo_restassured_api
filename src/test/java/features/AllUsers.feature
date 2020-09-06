Feature:
  Verify users endpoint

  Scenario: Verify users endpoint returns all users
    Given I perform GET operation for "/users"
    Then I should see "1000" users
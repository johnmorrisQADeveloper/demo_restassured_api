Feature:
  Verify users endpoint

  Scenario: Verify /city/valid city/users endpoint returns all users with the city
    When I perform GET operation for "/city/London/users"
    Then I should see "6" users

  Scenario: Verify /city/invalid city/users endpoint returns no users
    When I perform GET operation for "/city/Manchester/users"
    Then I should see "0" users
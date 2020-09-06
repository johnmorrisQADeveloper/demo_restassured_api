Feature:
  Verify userid endpoint

  Scenario: Verify /user/1 endpoint returns first user
    Given I perform GET operation for "/user/1"
    Then I should see property "id" with "1"
    Then I should see property "city" with "Kax"
    Then I should see property "first_name" with "Maurise"

  Scenario: Verify /user/1001 endpoint returns first user
    Given I perform GET operation for "/user/1001"
    Then I should see property "message" with "Id 1001 doesn't exist. You have requested this URI [/user/1001] but did you mean /user/<string:id> or /users ?"
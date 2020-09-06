Feature:
  Verify userid endpoint

  Scenario: Verify /user/1 endpoint returns first user
    Given I perform GET operation for "/user/1"
    Then I should see property "id" to be "1"
    Then I should see property "city" to be "Kax"
    Then I should see property "first_name" to be "Maurise"

  Scenario: Verify /user/1001 endpoint returns no user
    Given I perform GET operation for "/user/1001"
    Then I should get "404" status code
    Then I should see property "message" to be "Id 1001 doesn't exist. You have requested this URI [/user/1001] but did you mean /user/<string:id> or /users ?"

  Scenario: Verify /user/0 endpoint returns no user
    Given I perform GET operation for "/user/0"
    Then I should get "404" status code
    Then I should see property "message" to be "Id 0 doesn't exist. You have requested this URI [/user/0] but did you mean /user/<string:id> or /users ?"
Feature:
  Verify userid endpoint

  Scenario: Verify /user/1 endpoint returns first user
    When I perform GET operation for "/user/1"
    Then I should see below properties
      | id          | 1                      |
      | first_name  | Maurise                |
      | last_name   | Shieldon               |
      | email       | mshieldon0@squidoo.com |
      | ip_address  | 192.57.232.111         |
      | city        | Kax                    |

  Scenario: Verify /user/1001 endpoint returns no user
    When I perform GET operation for "/user/1001"
    Then I should see property "message" with text:
      | Id 1001 doesn't exist. You have requested this URI [/user/1001] but did you mean /user/<string:id> or /users ? |
    And I should get "404" status code

  Scenario: Verify /user/0 endpoint returns no user
    When I perform GET operation for "/user/0"
    Then I should see property "message" with text:
      | Id 0 doesn't exist. You have requested this URI [/user/0] but did you mean /user/<string:id> or /users ? |
    And I should get "404" status code
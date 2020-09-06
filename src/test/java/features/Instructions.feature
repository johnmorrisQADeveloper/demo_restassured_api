Feature:
  Verify instructions endpoint

  Scenario: Verify instructions endpoint returns a todo object
    Given I perform GET operation for "/instructions"
    Then I should see text value of "todo" object
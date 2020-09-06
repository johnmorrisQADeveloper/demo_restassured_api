# Build Status - [![Build Status](https://github.com/johnmorrisQADeveloper/demo_restassured_api/workflows/main/badge.svg?branch=master)](.github/workflows/restapi.yml)

# RestAssured API Automation via Cucumber

As per Swagger Definition, only GET endpoint is defined. The scope of
the automation only covers GET method.
 
| Endpoint              | Expect            | Actual              |
|:-------------         |:-------------     | :-----              |
| /swagger.json         | Swagger Definition| Swagger Definition  |
| /instructions         | todo Object       | todo Object         |
| /user/{id}            | userid Object     | userid Object       |
| /city/cityname/users  | users within city | users within city   |
| /users                | all users         | all users           |

# Test Observation
1. Invalid user/{id} - Since id are integers, it would be good for API to return 
something like please enter a valid number instead of the output below.
```
Actual
curl --location --request GET 'http://bpdts-test-app-v2.herokuapp.com/user/we'
{"message": "Id we doesn't exist. You have requested this URI [/user/we] but did you mean /user/<string:id> or /users ?"}
```
On the above premise
```
Feature:
  Verify userid endpoint with invalid entries

  Scenario: Verify /user/1001 endpoint returns no user
    When I perform GET operation for "/user/we"
    Then I should see property "message" to be "please enter a valid number"
    And I should get "404" status code
```

# Run all feature files via terminal
```
mvn clean install

mvn exec:java                                  \
    -Dexec.classpathScope=test                 \
    -Dexec.mainClass=io.cucumber.core.cli.Main \
    -Dexec.args="src/test/java/features --glue steps"
```

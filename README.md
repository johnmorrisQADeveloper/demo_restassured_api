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

# Run all feature files via terminal
```
mvn clean install

mvn exec:java                                  \
    -Dexec.classpathScope=test                 \
    -Dexec.mainClass=io.cucumber.core.cli.Main \
    -Dexec.args="src/test/java/features --glue steps"
```

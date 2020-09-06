# RestAssured API Automation via Cucumber


# Run all feature files via terminal
```
mvn clean install

mvn exec:java                                  \
    -Dexec.classpathScope=test                 \
    -Dexec.mainClass=io.cucumber.core.cli.Main \
    -Dexec.args="src/test/java/features --glue steps"
```

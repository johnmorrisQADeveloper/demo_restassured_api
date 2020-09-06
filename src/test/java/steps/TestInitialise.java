package steps;

import io.cucumber.java.Before;
import utilities.RestAssuredExtension;

public class TestInitialise {
    @Before
    public void TestSetup() {
        RestAssuredExtension restAssuredExtension = new RestAssuredExtension();
    }
}

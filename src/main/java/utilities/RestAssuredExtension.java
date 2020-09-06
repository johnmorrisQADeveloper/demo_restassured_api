package utilities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

public class RestAssuredExtension {
    public static RequestSpecification Request;

    public static String getBaseURL() {
        String url = "";
        try (InputStream input = new FileInputStream("./src/main/resources/config.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            url = prop.getProperty("endpointURL");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return url;
    }

    public RestAssuredExtension() {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri(getBaseURL());
        builder.setContentType(ContentType.JSON);
        var requestSpec = builder.build();
        Request = RestAssured.given().spec(requestSpec);
    }

    public static ResponseOptions<Response> GetOps(String url)  {
        try {
            return Request.get(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

}

package utils.cloud;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class ApiRequest {
    private static final String API_URL = "https://mobilecloud.epam.com/automation/api";

    public ApiRequest() {
    }

    public static void main(String[] args) {

        takeDevice("520029ade81da58f", System.getenv("TOKEN"));
        //should be fileId instead of appPath
        appInstall("520029ade81da58f", System.getenv("TOKEN"), ".//src/main/resources/EPAMTestApp.apk");
    }

    public static void takeDevice(String serial, String key) {
        System.out.println("Taking available device in use by unique id");
        Response response = given().header("Authorization", format("Bearer %s", key))
                .header("Content-Type", "application/json")
                .when().post(format("%s/device/%s", API_URL, serial));
        System.out.println("Response Status code is " + response.getStatusCode()); // Log for status code
    }

    private static void appInstall(String serial, String key, String fileId) {
        System.out.println("start app installation");
        Response response = given().header("Authorization", format("Bearer %s", key))
                .when().get(format("%s/storage/install/%s/%s", API_URL, serial, fileId));
        System.out.println("Response Status code is " + response.getStatusCode()); // Log for status code
        response.getBody().prettyPeek();
    }
}

package utils.cloud;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class ApiRequest {
    private static final String API_URL = "https://mobilecloud.epam.com/automation/api";
    private static String API_KEY = System.getenv("TOKEN");
    public ApiRequest() {
    }

    public static void main(String[] args) {
//        takeDevice("YPNBZ975QOQCWKUG");
        //       stopUseDevice("YPNBZ975QOQCWKUG");
    }

    public static void takeDevice(String serial) {
        System.out.println("Taking available device in use by unique id");
        Response response = given().header("Authorization", format("Bearer %s", API_KEY))
                .header("Content-Type", "application/json")
                .when().post(format("%s/device/%s", API_URL, serial));              // .prettyPeek();
        System.out.println("Response Status code is " + response.getStatusCode()); // Log for status code
    }

    private static void appInstall(String serial, String fileId) {
        System.out.println("start app installation");
        Response response = given().header("Authorization", format("Bearer %s", API_KEY))
                .when().get(format("%s/storage/install/%s/%s", API_URL, serial, fileId));
        System.out.println("Response Status code is " + response.getStatusCode()); // Log for status code
    }

    public static void stopUseDevice(String serial) {
        System.out.println("Stop using device with unique id");
        Response response = given().header("Authorization", format("Bearer %s", API_KEY))
                .header("Content-Type", "application/json")
                .when().delete(format("%s/device/%s", API_URL, serial))
                .prettyPeek();
        System.out.println("Response Status code is " + response.getStatusCode()); // Log for status code
    }

}

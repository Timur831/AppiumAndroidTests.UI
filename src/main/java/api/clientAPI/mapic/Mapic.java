package api.clientAPI.mapic;

import api.clientAPI.BaseAPI;
import api.specifications.Specification;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Mapic extends BaseAPI {

    public static String getToken(){
        Map<String, String> mapicBody = new HashMap<>();
        mapicBody.put("grant_type", "client_credentials");

        Response response = given()
                .spec(Specification.requestMapic())
                //.contentType("application/x-www-form-urlencoded")
                .header("Authorization", "Basic dU9PUjVIOElnU2RFRENHTG5wbURqMEhqRF9FYTpMOVdGOW5tMTBsYTJMYU9oeTFJSzNpc1FTZlFh")
                //.formParam("grant_type", "client_credentials")
                .auth().basic("uOOR5H8IgSdEDCGLnpmDj0HjD_Ea", "L9WF9nm10la2LaOhy1IK3isQSfQa")
                .body(mapicBody)
                .expect()
                //.spec(Specification.responseSpec200())
                .when()
                .post("http://stage.mapic-dev.vimpelcom.ru/gw-auth/1.0.0/token");
        response.then().log().all();
        return response.jsonPath().getString("access_token");
    }
}

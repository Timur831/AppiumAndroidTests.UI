package api.clientAPI.unifiedBalanceProfile;

import api.clientAPI.BaseAPI;
import api.specifications.Specification;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class UnifiedBalance extends BaseAPI {

    @Step("Расформирование UB")
    @Description("DELETE /profile")
    public static Response reformUB(String xCtn){
        Response response = given()
                .spec(Specification.requestSpecUBProfile())
                .header("X-CTN", xCtn)
                .expect()
                .spec(Specification.responseSpec200())
                .when()
                .delete("/profile");
        softAssert.assertEquals(response.jsonPath().getString("status"), "Success");
        response.then().log().all();
        return response;
    }

    @Step("Получение группы UB с SSO")
    @Description("GET /profile")
    public static Response getUBGroupWithSSO(String xCtn){
        Response response = given()
                .spec(Specification.requestSpecUBProfile())
                .header("X-CTN", xCtn)
                .expect()
                .spec(Specification.responseSpec200())
                .when()
                .get("/profile");
        response.then().log().all();
        return response;
    }
}

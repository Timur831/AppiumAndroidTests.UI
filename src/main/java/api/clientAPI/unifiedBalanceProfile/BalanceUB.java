package api.clientAPI.unifiedBalanceProfile;

import api.clientAPI.BaseAPI;
import api.specifications.Specification;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BalanceUB extends BaseAPI {

    @Step("Получение баланса UB")
    @Description("GET /balance/unified")
    public static Response getStatusUB(String xCtn){
        Response response = given()
                .spec(Specification.requestSpecUBProfile())
                .header("X-CTN", xCtn)
                .expect()
                .spec(Specification.responseSpec200())
                .when()
                .get("/balance/unified");
        response.then().log().all();
        return response;
    }
}

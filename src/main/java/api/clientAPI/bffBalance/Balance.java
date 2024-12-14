package api.clientAPI.bffBalance;

import api.clientAPI.BaseAPI;
import api.specifications.Specification;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Balance extends BaseAPI {

    @Step("Получение баланса")
    @Description("GET /balance")
    public static Response getBalance(String xCtn){
        Response response = given()
                .spec(Specification.requestSpecUB())
                .header("X-CTN", xCtn)
                .expect()
                .spec(Specification.responseSpec200())
                .when()
                .get("/balance");
        response.then().log().all();
        return response;
    }

    @Step("Получение баланса ШПД")
    @Description("GET /balance/inac")
    public static Response getInacBalance(String xCtn){
        Response response = given()
                .spec(Specification.requestSpecUB())
                .header("X-CTN", xCtn)
                .expect()
                .spec(Specification.responseSpec200())
                .when()
                .get("/balance/inac");
        response.then().log().all();
        return response;
    }

    @Step("Получение баланса Prepaid")
    @Description("GET /balance/prepaid")
    public static Response getPrepaidBalance(String xCtn){
        Response response = given()
                .spec(Specification.requestSpecUB())
                .header("X-CTN", xCtn)
                .expect()
                .spec(Specification.responseSpec200())
                .when()
                .get("/balance/prepaid");
        response.then().log().all();
        return response;
    }

}

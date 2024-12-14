package api.clientAPI.unifiedBalanceProfile;

import api.clientAPI.BaseAPI;
import api.specifications.Specification;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Ctn extends BaseAPI {
    @Step("Добавление ctn в UB")
    @Description("POST /profile/ctn")
    public static Response createUB(String xCtn, String ctn) {
        Response response = given()
                .spec(Specification.requestSpecUBProfile())
                .header("X-CTN", xCtn)
                .queryParam("ctn", ctn)
                .expect()
                .spec(Specification.responseSpec200())
                .when()
                .post("/profile/ctn");
        softAssert.assertEquals(response.jsonPath().getString("status"), "Success");
        response.then().log().all();
        return response;
    }

    @Step("Получение группы UB")
    @Description("GET /profile/ctn")
    public static Response getUBGroup(String xCtn){
        Response response = given()
                .spec(Specification.requestSpecUBProfile())
                .header("X-CTN", xCtn)
                .expect()
                .spec(Specification.responseSpec200())
                .when()
                .get("/profile/ctn");
        response.then().log().all();
        return response;
    }

    @Step("Выход из UB")
    @Description("DELETE /profile/ctn")
    public static Response leaveUBGroup(String xCtn){
        Response response = given()
                .spec(Specification.requestSpecUBProfile())
                .header("X-CTN", xCtn)
                .expect()
                .spec(Specification.responseSpec200())
                .when()
                .delete("/profile/ctn");
        response.then().log().all();
        return response;
    }

    @Step("Удаление из группы UB")
    @Description("UPDATE /profile/ctn")
    public static Response updateFromUBGroup(String xCtn, String ctn, String status){
        Response response = given()
                .spec(Specification.requestSpecUBProfile())
                .header("X-CTN", xCtn)
                .queryParams("ctn", ctn, "status", status)
                .expect()
                .spec(Specification.responseSpec200())
                .when()
                .put("/profile/ctn");
        response.then().log().all();
        return response;
    }

    @Step("Переименовать CTN в ОБ")
    @Description("UPDATE /profile/ctn/settings")
    public static Response editCtnName(String xCtn, String ctn, String name){
        Map<String, String> bodyForEditName = new HashMap<>();
        bodyForEditName.put("ctn", ctn);
        bodyForEditName.put("nickname", name);
        Response response = given()
                .spec(Specification.requestSpecUBProfile())
                .header("X-CTN", xCtn)
                .body(bodyForEditName)
                .expect()
                .spec(Specification.responseSpec200())
                .when()
                .put("/profile/ctn/settings");
        response.then().log().all();
        return response;
    }
}

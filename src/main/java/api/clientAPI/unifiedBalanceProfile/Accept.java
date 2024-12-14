package api.clientAPI.unifiedBalanceProfile;

import api.clientAPI.BaseAPI;
import api.specifications.Specification;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class Accept extends BaseAPI {

    @Step("Подтверждение подключения к UB через ввод кода из СМС")
    @Description("GET /sms")
    public static void acceptWithSMSCode(String numMain,String numSlave, String code){
        Response response = given()
                .spec(Specification.requestSpecUBProfile())
                .queryParams("ctn", numSlave, "code", code)
                .header("X-CTN", numMain)
                .expect()
                .spec(Specification.responseSpec200())
                .when()
                .get("/profile/ctn/accept");
        response.then().log().all();
        Assert.assertEquals(response.jsonPath().getString("status"), "Success");
    }
}

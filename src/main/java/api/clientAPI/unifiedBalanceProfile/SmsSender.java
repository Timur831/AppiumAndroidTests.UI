package api.clientAPI.unifiedBalanceProfile;

import api.clientAPI.BaseAPI;
import api.pojo.Sms;
import api.specifications.Specification;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class SmsSender extends BaseAPI {

    @Step("Получение SMS с кодом")
    @Description("GET /sms")
    public static String getSMSCode(String num){
        Response response = given()
                .spec(Specification.requestSpecUBSms())
                .header("X-CTN", num)
                .expect()
                .spec(Specification.responseSpec200())
                .when()
                .get("/sms");
        response.then().log().all();
        List<Sms> smsList = response.jsonPath().getList("", Sms.class);
        return smsList.get(smsList.size() - 1).code;
    }
}

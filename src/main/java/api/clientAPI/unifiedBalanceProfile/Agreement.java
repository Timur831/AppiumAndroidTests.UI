package api.clientAPI.unifiedBalanceProfile;

import api.clientAPI.BaseAPI;
import api.specifications.Specification;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Agreement extends BaseAPI {

    @Step("Подтверждение оферты")
    @Description("GET /profile/agreement")
    public static void acceptAgreement(String num){
        Response response = given()
                .spec(Specification.requestSpecUBProfile())
                .header("X-CTN", num)
                .expect()
                .spec(Specification.responseSpec200())
                .when()
                .put("/profile/agreement");
        response.then().log().all();
        softAssert.assertEquals(response.jsonPath().getString("status"), "Success");
    }
}

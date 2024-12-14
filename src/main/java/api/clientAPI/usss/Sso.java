package api.clientAPI.usss;

import api.helper.SsoHashGenerator;
import api.pojo.SsoCtnUser;
import api.specifications.Specification;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import static androidApp.AppConfig.PASSWORD;
import static io.restassured.RestAssured.given;

public class Sso {
    @Step("Добавление в SSO")
    @Description("/sso/linkage/loginAndPassword/creation")
    public static Response addToSso(String login, String linkedAccountLogin) throws NoSuchAlgorithmException, InvalidKeyException {
        SsoCtnUser ssoCtnUser = new SsoCtnUser(PASSWORD, linkedAccountLogin, login);
        String hash = SsoHashGenerator.getSsoHash(ssoCtnUser, "add");

        Response response = given()
                .spec(Specification.requestSpecUsss())
                .headers("Cookie", "token=16A7665A159997FCE95B9D5F9B026EEK; ui.language.current=ru_RU", "Content-Type", "application/json")
                .queryParams("linkedAccountPassword", ssoCtnUser.linkedAccountPassword, "linkedAccountLogin", ssoCtnUser.linkedAccountLogin, "login", ssoCtnUser.login, "hash", hash)
                .body(ssoCtnUser)
                .expect()
                .spec(Specification.responseSpec200())
                .when()
                .put("http://usssfttb-test.vimpelcom.ru:22001/api/1.0/sso/linkage/loginAndPassword/creation");
        response.then().log().all();
        return response;
    }

    @Step("Получение списка ctn в SSO")
    @Description("/sso/list")
    public static List<String> getListSso(String login) throws NoSuchAlgorithmException, InvalidKeyException {
        SsoCtnUser ssoCtnUser = new SsoCtnUser(PASSWORD, login);
        String hash = SsoHashGenerator.getSsoHash(ssoCtnUser, "get");

        Response response = given()
                .spec(Specification.requestSpecUsss())
                .headers("Cookie", "token=16A7665A159997FCE95B9D5F9B026EEK; ui.language.current=ru_RU", "Content-Type", "application/json")
                .queryParams("login", ssoCtnUser.login, "hash", hash)
                .expect()
                .spec(Specification.responseSpec200())
                .when()
                .get("http://usssfttb-test.vimpelcom.ru:22001/api/2.0/sso/list");
        response.then().log().all();
        List<String> listOfCtn = response.jsonPath().getList("ssoAccountList.name");
        listOfCtn.remove(login);
        return listOfCtn;
    }

    @Step("Удаление ctn из SSO")
    @Description("/sso/delAccountLink")
    public static Response deleteCtnFromSso(String login, String linkedAccountLogin) throws NoSuchAlgorithmException, InvalidKeyException {
        SsoCtnUser ssoCtnUser = new SsoCtnUser(PASSWORD, linkedAccountLogin, login);
        String hash = SsoHashGenerator.getSsoHash(ssoCtnUser, "delete");

        Response response = given()
                .spec(Specification.requestSpecUsss())
                .headers("Cookie", "token=16A7665A159997FCE95B9D5F9B026EEK; ui.language.current=ru_RU", "Content-Type", "application/json")
                .queryParams("login", ssoCtnUser.login, "linkedLogin", ssoCtnUser.linkedAccountLogin, "hash", hash)
                .expect()
                .spec(Specification.responseSpec200())
                .when()
                .get("http://usssfttb-test.vimpelcom.ru:22001/api/1.0/sso/delAccountLink");
        response.then().log().all();
        return response;
    }

    @Step("Удаление всех ctn из SSO")
    public static void deleteAllCtnFromSso(String login) throws NoSuchAlgorithmException, InvalidKeyException {
        List<String> listOfCtn = getListSso(login);
        if (!listOfCtn.isEmpty()) {
            for (String ctn : listOfCtn) {
                deleteCtnFromSso(login, ctn);
            }
        }
    }

    @Step("Изменить имя ctn в SSO")
    @Description("/sso/delAccountLink")
    public static Response editSsoName(String login, String name, String linkedAccountLogin) throws NoSuchAlgorithmException, InvalidKeyException {
        SsoCtnUser ssoCtnUser = new SsoCtnUser(linkedAccountLogin, login, name);
        String hash = SsoHashGenerator.getSsoHash(ssoCtnUser, "changeName");

        Response response = given()
                .spec(Specification.requestSpecUsss())
                .headers("Cookie", "token=16A7665A159997FCE95B9D5F9B026EEK; ui.language.current=ru_RU", "Content-Type", "application/json")
                .queryParams("linkedAccountLogin", ssoCtnUser.linkedAccountLogin, "nickname", ssoCtnUser.nickName, "login", ssoCtnUser.login, "hash", hash)
                .body(ssoCtnUser)
                .expect()
                .spec(Specification.responseSpec200())
                .when()
                .put("http://usssfttb-test.vimpelcom.ru:22001/api/1.0/sso/linkage/changeLinkedAccountNickname");
        response.then().log().all();
        return response;
    }
}

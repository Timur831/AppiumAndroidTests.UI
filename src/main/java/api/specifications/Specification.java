package api.specifications;

import api.utility.UBProperties;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.Properties;

public class Specification {
    protected static final Properties props = UBProperties.readConfigurationFile();

    public static RequestSpecification requestSpecUB(){
        return new RequestSpecBuilder()
                .addFilter(new AllureRestAssured())
                .setBaseUri(props.getProperty("uri.ub"))
                .setContentType(ContentType.JSON)
                .build();
    }
    public static RequestSpecification requestSpecUBProfile(){
        return new RequestSpecBuilder()
                .addFilter(new AllureRestAssured())
                .setBaseUri(props.getProperty("uri.ub.profile"))
                .setContentType(ContentType.JSON)
                .build();
    }
    public static RequestSpecification requestSpecUBSms(){
        return new RequestSpecBuilder()
                .addFilter(new AllureRestAssured())
                .setBaseUri(props.getProperty("uri.ub.sms"))
                .setContentType(ContentType.JSON)
                .build();
    }
    public static RequestSpecification requestSpecUsss(){
        return new RequestSpecBuilder()
                .addFilter(new AllureRestAssured())
                //.setBaseUri(props.getProperty("uri.usss"))
                //.setContentType(ContentType.JSON)
                .build();
    }
    public static RequestSpecification requestMapic(){
        return new RequestSpecBuilder()
                .addFilter(new AllureRestAssured())
                //.setBaseUri(props.getProperty("uri.mapic"))
                //.setContentType(ContentType.JSON)
                .build();
    }
    public static ResponseSpecification responseSpec200(){
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }

    public static ResponseSpecification responseSpec400(){
        return new ResponseSpecBuilder()
                .expectStatusCode(400)
                .build();
    }
}


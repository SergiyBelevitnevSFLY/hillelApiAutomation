import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SpecificationsRestAssured {

    private static RequestSpecification zipopotamRequestSpecification;
    private static ResponseSpecification zipopotamResponseSpecification;

    @BeforeMethod
    public void setRequestSpecification(){
        zipopotamRequestSpecification = new RequestSpecBuilder()
                .setBaseUri("http://api.zippopotam.us/").build();
    }

    @BeforeMethod
    public void setResponseSpecification(){
        zipopotamResponseSpecification = new ResponseSpecBuilder().expectStatusCode(HttpStatus.SC_OK)
                .expectContentType(ContentType.JSON).build();
    }


    @Test
    public void firstTest(){
        given()
                .spec(zipopotamRequestSpecification)
                .when()
                .get("us/90210")
                .then().spec(zipopotamResponseSpecification)
                .log()
                .all();
    }
}

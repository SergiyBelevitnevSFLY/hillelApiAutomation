import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.*;

public class FirstRestAssuredTest {


    @Test
    public void firstRestAssuredTest(){

        Response response =given()
                .when()
                .get("http://api.zippopotam.us/us/90210");

        String state = response.body().jsonPath().get("places[0].'state'");
        System.out.println("The state is " + state);

//        response.then()
//                .assertThat()
//                .statusCode(200)
//                .assertThat().contentType(JSON)
//                .assertThat().body("places[0].'place name'", equalTo("Beverly Hills"))
//                .log()
//                .body();

        response.then()
                .assertThat()
                .statusCode(200)
                .assertThat().contentType(JSON)
                .assertThat().body("places.'place name'", hasItem("Beverly Hills"))
                .assertThat().body("places.'place name'", hasSize(1))
                .assertThat().body("places[0].'place name'", equalTo("Beverly Hills"))
                .log()
                .body();

//        response.then()
//                .assertThat()
//                .statusCode(200)
//                .assertThat().contentType(JSON)
//                .assertThat().body("places.'place name'", hasSize(1))
//                .log()
//                .body();

    }
}

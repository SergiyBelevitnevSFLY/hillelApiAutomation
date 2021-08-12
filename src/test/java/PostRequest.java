import dataEntity.users.UsersCollection;
import dataEntity.users.UsersPostRequestPayload;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostRequest {


    @Test
    public void postRequest(){

        given().body("{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}")
                .when()
                .post("https://reqres.in/api/users")
                .then().assertThat().statusCode(HttpStatus.SC_CREATED)
                .log().body();
    }

    @Test
    public void postRequestWithPOJO(){

        UsersPostRequestPayload usersPostRequestPayload = new UsersPostRequestPayload("QA","Yur");


        given()
                .body(usersPostRequestPayload)
                .when()
                .post("https://reqres.in/api/users")
                .then().assertThat().statusCode(HttpStatus.SC_CREATED)
                .log().body();
    }


    @Test
    public void postRequestWithPOJOAndParams(){



       UsersCollection usersCollection = given()
                .when()
                .param("page",2)
                .get("https://reqres.in/api/users").as(UsersCollection.class);

        System.out.println("");

//                .then()
//                .assertThat().statusCode(HttpStatus.SC_CREATED)
//                .log().body();
    }
}

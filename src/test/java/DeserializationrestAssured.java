import dataEntity.zip.ZipResponse;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeserializationrestAssured {


    @Test
    public void deserializationRestAssured(){
        Response response =given()
                .when()
                .get("http://api.zippopotam.us/us/90210");
        response.then().log().body();

        ZipResponse zipResponse = response.as(ZipResponse.class);
        String placeName = zipResponse.getPlaces().get(0).getPlaceName();
        System.out.println(placeName);
    }
}

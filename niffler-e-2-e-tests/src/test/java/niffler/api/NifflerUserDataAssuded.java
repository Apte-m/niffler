package niffler.api;

import io.restassured.response.Response;
import niffler.dto.User;

import static io.restassured.RestAssured.given;

public class NifflerUserDataAssuded implements NifflerUserDataServiceAssured {


    @Override
    public Response updateUserAssured(User userJson) {
        return given().spec(NifflerUserDataServiceAssured.spec)
                .body(userJson)
                .post();
    }
}

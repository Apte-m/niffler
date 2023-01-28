package niffler.api;

import io.restassured.response.Response;
import niffler.model.UserJson;
import okhttp3.OkHttpClient;

import static io.restassured.RestAssured.given;

public class NifflerUserDataAssuded  implements NifflerUserDataServiceAssured{



    @Override
    public Response updateUserAssured(UserJson userJson) {
        return given().spec(NifflerUserDataServiceAssured.spec)
                .body(userJson)
                .post();
    }
}

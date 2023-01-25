package niffler.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import niffler.model.UserJson;

public interface NifflerUserDataServiceAssured {

    RequestSpecification spec = RestAssured.given()
            .baseUri("http://127.0.0.1:8089")
            .basePath("/updateUserInfo")
            .contentType(ContentType.JSON);

   Response updateUserAssured (UserJson userJson);
}

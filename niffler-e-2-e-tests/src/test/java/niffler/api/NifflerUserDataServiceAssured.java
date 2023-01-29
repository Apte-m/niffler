package niffler.api;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import niffler.dto.User;

public interface NifflerUserDataServiceAssured {

    RequestSpecification spec = new RequestSpecBuilder()
            .setBaseUri("http://127.0.0.1:8089")
            .setBasePath("/updateUserInfo")
            .setContentType(ContentType.JSON)
            .addFilter(new AllureRestAssured())
            .build();

    //TODO  лучше  Response updateUserAssured (Object o);  и создать 4 интерфейса CRUD , но как пример норм
    Response updateUserAssured(User userJson);
}

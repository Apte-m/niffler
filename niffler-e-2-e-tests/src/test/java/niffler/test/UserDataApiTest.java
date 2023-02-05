package niffler.test;

import io.qameta.allure.Allure;
import niffler.api.NifflerUserDataAssuded;
import niffler.api.NifflerUserDataClient;
import niffler.converter.UserData;
import niffler.converter.UsersData;
import niffler.dto.ResponseUsers;
import niffler.dto.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserDataApiTest {

    private NifflerUserDataClient nifflerUserDataClient = new NifflerUserDataClient();
    private NifflerUserDataAssuded nifflerUserDataAssuded = new NifflerUserDataAssuded();


    @ValueSource(strings = {
            "data/userOne.json",
            "data/userThree.json"
    })
    @ParameterizedTest
    void userUpdateData(@UserData User userJson)  {
        Allure.step("обновление через retrofit", () -> {
            User created = nifflerUserDataClient.updateUser(userJson);

            Assertions.assertAll(
                    () -> assertNotNull(created.getUserName()),
                    () -> assertNotNull(created.getFirstname()),
                    () -> assertNotNull(created.getCurrency())
            );
        });


    }

    @ValueSource(strings = {"data/userTwo.json"})
    @ParameterizedTest
    void userUpdateDataRestAssured(@UsersData ResponseUsers userJson) {

      userJson.getUser().stream().forEach( v -> {
          nifflerUserDataAssuded.updateUserAssured(v).as(User.class);
          Assertions.assertAll(
                    () -> assertNotNull(v.getUserName()),
                    () -> assertNotNull(v.getFirstname()),
                    () -> assertNotNull(v.getCurrency())
            );
      });


    }
}

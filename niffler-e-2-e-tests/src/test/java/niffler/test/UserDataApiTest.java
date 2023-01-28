package niffler.test;

import niffler.api.NifflerUserDataAssuded;
import niffler.api.NifflerUserDataClient;
import niffler.converter.UserData;
import niffler.model.UserJson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserDataApiTest {

    private NifflerUserDataClient nifflerUserDataClient = new NifflerUserDataClient();
    private NifflerUserDataAssuded nifflerUserDataAssuded = new NifflerUserDataAssuded();


    @ValueSource(strings = {
            "data/userOne.json",
            "data/userTwo.json"
    })
    @ParameterizedTest
    void userUpdateData(@UserData UserJson userJson) throws Exception {
        UserJson created = nifflerUserDataClient.updateUser(userJson);

        Assertions.assertAll(
                () -> assertNotNull(created.getUserName()),
                () -> assertNotNull(created.getFirstname()),
                () -> assertNotNull(created.getCurrency())
        );


    }

    @ValueSource(strings = {
            "data/userOne.json",
            "data/userTwo.json"
    })
    @ParameterizedTest
    void userUpdateDataRestAssured(@UserData UserJson userJson) {
        UserJson created = nifflerUserDataAssuded.updateUserAssured(userJson).as(UserJson.class);

        Assertions.assertAll(
                () -> assertNotNull(created.getUserName()),
                () -> assertNotNull(created.getFirstname()),
                () -> assertNotNull(created.getCurrency())
        );

    }


}

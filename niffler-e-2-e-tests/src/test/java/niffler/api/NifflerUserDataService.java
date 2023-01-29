package niffler.api;

import niffler.dto.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface NifflerUserDataService {

    String nifflerSpendUri = "http://127.0.0.1:8089";

    //TODO  лучше  Response updateUserAssured (Object o);  и создать 4 интерфейса CRUD , но как пример норм
    @POST("/updateUserInfo")
    Call<User> updateUserData(@Body User user);


}

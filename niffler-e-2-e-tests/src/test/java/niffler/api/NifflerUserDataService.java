package niffler.api;

import niffler.model.SpendJson;
import niffler.model.UserJson;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface NifflerUserDataService {

    String nifflerSpendUri = "http://127.0.0.1:8089";

    @POST("/updateUserInfo")
    Call<UserJson> updateUserData(@Body UserJson user);


}

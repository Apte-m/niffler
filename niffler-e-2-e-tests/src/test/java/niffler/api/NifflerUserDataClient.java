package niffler.api;

import niffler.dto.User;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class NifflerUserDataClient {

    private OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .build();


    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(NifflerUserDataService.nifflerSpendUri)
            .addConverterFactory(JacksonConverterFactory.create())
            .build();

    private NifflerUserDataService userDataService = retrofit.create(NifflerUserDataService.class);

    public User updateUser(User user) throws Exception {
        return userDataService.updateUserData(user).execute().body();
    }
}

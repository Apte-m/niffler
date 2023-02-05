package niffler.api;

import niffler.dto.Spend;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface NifflerSpendService {

    String nifflerSpendUri = "http://127.0.0.1:8093";

    @POST("/addSpend")
    Call<Spend> addSpend(@Body Spend spend);

}

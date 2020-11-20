package ajmitchell.android.bakingtime;

import ajmitchell.android.bakingtime.network.BakingApi;
import ajmitchell.android.bakingtime.utils.Constants;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static Retrofit retrofit;

    private static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
    private static BakingApi bakingApi = retrofit.create(BakingApi.class);

    public static BakingApi getBakingApi() {
        return bakingApi;
    }
}

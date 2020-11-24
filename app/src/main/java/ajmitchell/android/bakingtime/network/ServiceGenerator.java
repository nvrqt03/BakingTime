package ajmitchell.android.bakingtime.network;

import ajmitchell.android.bakingtime.network.BakingApi;
import ajmitchell.android.bakingtime.utils.Constants;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static Retrofit retrofit;
    private static BakingApi bakingApi;

    public static BakingApi getBakingApi() {
        if (bakingApi == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            bakingApi = retrofit.create(BakingApi.class);
        }
        return bakingApi;
    }
}

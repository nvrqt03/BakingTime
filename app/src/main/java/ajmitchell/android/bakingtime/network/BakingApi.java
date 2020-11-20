package ajmitchell.android.bakingtime.network;

import java.util.List;

import ajmitchell.android.bakingtime.models.Recipe;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface BakingApi {
    @GET("topher/2017/May/59121517_baking/baking.json")
    Flowable<List<Recipe>> getRecipeApi();
}

package ajmitchell.android.bakingtime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import ajmitchell.android.bakingtime.adapters.RecipeAdapter;
import ajmitchell.android.bakingtime.databinding.ActivityMainBinding;
import ajmitchell.android.bakingtime.models.Recipe;
import ajmitchell.android.bakingtime.network.BakingApi;
import ajmitchell.android.bakingtime.network.RetrofitClient;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements  RecipeAdapter.OnRecipeListener {

    ActivityMainBinding mBinding;
    public static final String TAG = "MainActivity.class";
    Retrofit retrofit;
    private RecyclerView recyclerView;
    private RecipeAdapter recipeAdapter;
    private List<Recipe> recipeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        recyclerView = mBinding.recipeRv;
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recipeAdapter = new RecipeAdapter(MainActivity.this, recipeList, recipeAdapter.mOnRecipeListener);
        recyclerView.setAdapter(recipeAdapter);

        //recipeList = new ArrayList<>();
        Observable<List<Recipe>> observable = RetrofitClient.getBakingApi().getRecipes();

        Log.d(TAG, "onCreate: " + observable.toString());


//        @NonNull Observable<Recipe> recipeObservable = Observable
//                .fromIterable(observable)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread());
//
//        recipeObservable.subscribe(new Observer<Recipe>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(@NonNull Recipe recipe) {
//                recipeList.add(recipe);
//
//
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//                Log.d(TAG, "onNext: it worked!" );
//            }
//        });
    }


    @Override
    public void onRecipeClick(Recipe recipe) {

    }
}
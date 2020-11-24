package ajmitchell.android.bakingtime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import ajmitchell.android.bakingtime.adapters.RecipeAdapter;
import ajmitchell.android.bakingtime.databinding.ActivityMainBinding;
import ajmitchell.android.bakingtime.models.Recipe;
import ajmitchell.android.bakingtime.network.BakingApi;
import ajmitchell.android.bakingtime.network.ServiceGenerator;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements  RecipeAdapter.OnRecipeListener {

    ActivityMainBinding mBinding;
    ServiceGenerator generator;
    BakingApi bakingApi;
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

        recipeList = new ArrayList<>();


        @NonNull Observable<List<Recipe>> recipeObservable = (Observable<List<Recipe>>) recipeList;

        recipeObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        recipeObservable.subscribe(new Observer<List<Recipe>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull List<Recipe> recipes) {
                recipeList.add(new Recipe());
                recipeAdapter = new RecipeAdapter(MainActivity.this, recipeList, this);
                recyclerView.setAdapter(recipeAdapter);
                Log.d(TAG, "onNext: it worked!" + recipes.toString());
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }


    @Override
    public void onRecipeClick(Recipe recipe) {

    }
}
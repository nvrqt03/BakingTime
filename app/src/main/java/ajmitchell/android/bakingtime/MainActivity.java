package ajmitchell.android.bakingtime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;

import java.util.List;

import ajmitchell.android.bakingtime.adapters.RecipeAdapter;
import ajmitchell.android.bakingtime.databinding.ActivityMainBinding;
import ajmitchell.android.bakingtime.models.Ingredient;
import ajmitchell.android.bakingtime.models.Recipe;
import ajmitchell.android.bakingtime.models.Step;
import ajmitchell.android.bakingtime.network.BakingApi;
import ajmitchell.android.bakingtime.network.RetrofitClient;
import io.reactivex.rxjava3.android.MainThreadDisposable;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements RecipeAdapter.RecipeItemClickListener {

    ActivityMainBinding mBinding;
    public static final String TAG = "MainActivity.class";
    private RecyclerView recyclerView;
    private List<Recipe> recipeList;
    private RecipeAdapter adapter;
    BakingApi bakingApi;
    private RecipeAdapter.RecipeItemClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        recyclerView = mBinding.recipeRv;
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecipeAdapter(recipeList, listener);
        recyclerView.setAdapter(adapter);

        Retrofit retrofit = RetrofitClient.getInstance();
        bakingApi = retrofit.create(BakingApi.class);

        Observable<List<Recipe>> observable = bakingApi.getRecipes();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Recipe>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<Recipe> recipes) {
                        displayData(recipes);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e(TAG, "onError: ", e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    private void displayData(List<Recipe> recipes) {
        adapter = new RecipeAdapter(recipes, this);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onRecipeItemClick(Recipe recipe) {

        Intent intent = new Intent(MainActivity.this, RecipeDetailActivity.class);
        intent.putExtra("recipeIntent", recipe);
        startActivity(intent);



        RecipeDetailFragment fragment = new RecipeDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("recipe", recipe);
        bundle.putParcelable("ingredient", (Parcelable) recipe.getIngredients());
        bundle.putParcelable("step", (Parcelable) recipe.getSteps());
        fragment.setArguments(bundle);

        Log.d(TAG, "onRecipeClick: clicked!");
    }
}
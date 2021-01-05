package ajmitchell.android.bakingtime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import ajmitchell.android.bakingtime.adapters.StepAdapter;
import ajmitchell.android.bakingtime.databinding.ActivityMainBinding;
import ajmitchell.android.bakingtime.databinding.ActivityRecipeDetailBinding;
import ajmitchell.android.bakingtime.databinding.RecipeItemBinding;
import ajmitchell.android.bakingtime.models.Ingredient;
import ajmitchell.android.bakingtime.models.Recipe;
import ajmitchell.android.bakingtime.models.Step;

public class RecipeDetailActivity extends AppCompatActivity {

    ActivityRecipeDetailBinding mBinding;
    public static final String TAG = "RecipeDetailActivity.class";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_recipe_detail);

        Intent intent = getIntent();
        Recipe recipe = intent.getExtras().getParcelable("recipeIntent");
        mBinding.setRecipe(recipe);

        initFragment();

    }

    private void initFragment() {
        RecipeDetailFragment recipeDetailFragment = new RecipeDetailFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.recipe_detail, recipeDetailFragment)
                .commit();
    }

}
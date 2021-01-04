package ajmitchell.android.bakingtime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import ajmitchell.android.bakingtime.databinding.ActivityRecipeStepDetailBinding;

public class RecipeStepDetailActivity extends AppCompatActivity {

    ActivityRecipeStepDetailBinding mBinding;
    ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_recipe_step_detail);
        init();
    }

    private void init() {
        RecipeStepDetailFragment recipeStepDetailFragment = new RecipeStepDetailFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.recipe_step_detail_fragment, recipeStepDetailFragment)
                .commit();
    }
}
package ajmitchell.android.bakingtime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
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
import ajmitchell.android.bakingtime.models.Step;

public class RecipeDetailActivity extends AppCompatActivity {

    ActivityRecipeDetailBinding mBinding;
    public static final String TAG = "RecipeDetailActivity.class";
    private RecyclerView ingredientRecyclerView;
    private RecyclerView stepRecyclerView;
    private StepAdapter stepAdapter;
    private List<Step> stepList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_recipe_detail);
        stepRecyclerView = mBinding.stepsRv;
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        stepRecyclerView.setLayoutManager(layoutManager);
        stepAdapter = new StepAdapter(RecipeDetailActivity.this, stepList);

        Intent intent = getIntent();
        if (intent == null) {
            closeOnError();
        }
    }
    private void closeOnError() {
        finish();
        Toast.makeText(this, R.string.notAvailable, Toast.LENGTH_SHORT).show();
    }
}
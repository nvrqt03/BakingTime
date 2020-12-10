package ajmitchell.android.bakingtime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import ajmitchell.android.bakingtime.databinding.ActivityMainBinding;
import ajmitchell.android.bakingtime.databinding.RecipeItemBinding;

public class RecipeDetailActivity extends AppCompatActivity {

    ActivityMainBinding mBinding;
    public static final String TAG = "RecipeDetailActivity.class";
    private RecyclerView ingredientRecyclerView;
    private RecyclerView stepRecyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_recipe_detail);
        stepRecyclerView = mBinding.steps_rv;
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        stepRecyclerView.setLayoutManager(layoutManager);
    }
}
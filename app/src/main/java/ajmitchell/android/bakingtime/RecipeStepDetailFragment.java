package ajmitchell.android.bakingtime;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ajmitchell.android.bakingtime.databinding.FragmentRecipeDetailBinding;
import ajmitchell.android.bakingtime.databinding.FragmentRecipeStepDetailBinding;
import ajmitchell.android.bakingtime.models.Ingredient;
import ajmitchell.android.bakingtime.models.Recipe;
import ajmitchell.android.bakingtime.models.Step;

public class RecipeStepDetailFragment extends Fragment {

    FragmentRecipeStepDetailBinding mBinding;

    //mandatory  constructor for instantiating the fragment (fragment recipe detail)
    public RecipeStepDetailFragment() {

    }

    // inflates the fragment layout - using databinding
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // inflate the fragment_recipe_detail layout
        mBinding = FragmentRecipeStepDetailBinding.inflate(inflater);

        Step step = new Step();

        mBinding.setStep(step);

        return mBinding.getRoot();
    }

}

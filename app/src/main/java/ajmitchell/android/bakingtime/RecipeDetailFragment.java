package ajmitchell.android.bakingtime;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.prefs.PreferenceChangeEvent;

import ajmitchell.android.bakingtime.databinding.FragmentRecipeDetailBinding;
import ajmitchell.android.bakingtime.models.Ingredient;
import ajmitchell.android.bakingtime.models.Recipe;
import ajmitchell.android.bakingtime.models.Step;


public class RecipeDetailFragment extends Fragment {

    FragmentRecipeDetailBinding binding;

    private Recipe recipe;
    private Ingredient ingredient;
    private Step step;

    //mandatory  constructor for instantiating the fragment (fragment recipe detail)
    public RecipeDetailFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            recipe = bundle.getParcelable("recipe");
            ingredient = bundle.getParcelable("ingredient");
            step = bundle.getParcelable("step");
        }
    }

    // inflates the fragment layout - using databinding
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // inflate the fragment_recipe_detail layout
        binding = FragmentRecipeDetailBinding.inflate(inflater);

        binding.setRecipe(recipe);
        binding.setIngredients(ingredient);
        binding.setStep(step);

        return binding.getRoot();
}
}


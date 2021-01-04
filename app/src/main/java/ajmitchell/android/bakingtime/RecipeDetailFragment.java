package ajmitchell.android.bakingtime;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ajmitchell.android.bakingtime.databinding.FragmentRecipeDetailBinding;
import ajmitchell.android.bakingtime.models.Ingredient;
import ajmitchell.android.bakingtime.models.Recipe;
import ajmitchell.android.bakingtime.models.Step;


public class RecipeDetailFragment extends Fragment {

    FragmentRecipeDetailBinding binding;
    Recipe mRecipe;
    Ingredient ingredient;
    Step step;

    //mandatory  constructor for instantiating the fragment (fragment recipe detail)
    public RecipeDetailFragment() {

    }

    // inflates the fragment layout - using databinding
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // inflate the fragment_recipe_detail layout
        binding = FragmentRecipeDetailBinding.inflate(inflater);

        Recipe recipe = new Recipe();
        Ingredient ingredient = new Ingredient();
        Step step = new Step();

        binding.setRecipe(recipe);
        binding.setIngredients(ingredient);
        binding.setStep(step);

        return binding.getRoot();
    }
}


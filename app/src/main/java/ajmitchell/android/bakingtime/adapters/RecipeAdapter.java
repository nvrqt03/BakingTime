package ajmitchell.android.bakingtime.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ajmitchell.android.bakingtime.R;
import ajmitchell.android.bakingtime.databinding.RecipeItemBinding;
import ajmitchell.android.bakingtime.models.Ingredient;
import ajmitchell.android.bakingtime.models.Recipe;
import ajmitchell.android.bakingtime.models.Step;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>  {

    private List<Recipe> recipeList;
    private final RecipeItemClickListener mListener;
    Context context;

    public RecipeAdapter(List<Recipe> recipes, RecipeItemClickListener listener) { //, OnRecipeListener onRecipeListener
        this.recipeList = recipes;
        this.mListener = listener;
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RecipeItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.recipe_item, parent, false);
        return new RecipeViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        holder.bind(recipeList.get(position), mListener);

    }

    @Override
    public int getItemCount() {
        if (recipeList == null) {
            return 0;
        }
        return recipeList.size();
    }


    public class RecipeViewHolder extends RecyclerView.ViewHolder {

        private RecipeItemBinding binding;

        public RecipeViewHolder(@NonNull RecipeItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Recipe recipe, RecipeItemClickListener clickListener) {
            binding.setRecipe(recipe);
            binding.setRecipeItemClick(clickListener);
            binding.executePendingBindings();
        }

    }
    
    public interface RecipeItemClickListener {
        void onRecipeItemClick(Recipe recipe);
    }
}

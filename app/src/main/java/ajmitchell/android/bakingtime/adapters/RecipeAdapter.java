package ajmitchell.android.bakingtime.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ajmitchell.android.bakingtime.R;
import ajmitchell.android.bakingtime.databinding.RecipeItemBinding;
import ajmitchell.android.bakingtime.models.Ingredient;
import ajmitchell.android.bakingtime.models.Recipe;
import ajmitchell.android.bakingtime.models.Step;
import io.reactivex.rxjava3.core.Observer;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder>  {

    private List<Recipe> recipeList;
    public OnRecipeListener mOnRecipeListener;
    Context context;

    public RecipeAdapter(Context context, List<Recipe> recipes, OnRecipeListener listener) { //, OnRecipeListener onRecipeListener
        this.context = context;
        this.recipeList = recipes;
        this.mOnRecipeListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        RecipeItemBinding recipeItemBinding = RecipeItemBinding.inflate(inflater, parent, false);
        ViewHolder viewHolder = new ViewHolder(recipeItemBinding, mOnRecipeListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Recipe recipeResults = recipeList.get(position);
        holder.bind(recipeResults, mOnRecipeListener);


//        Recipe recipeResults = recipeList.get(position);
//        List<Step> steps = recipeResults.getSteps();
//        List<Ingredient> ingredient = recipeResults.getIngredients();
//        holder.bind(recipeResults, steps.get(position), ingredient.get(position));
//        holder.binding.re = recipeList.get(position);
//        holder.binding.executePendingBindings();
        //holder.bind(steps.get(position));
    }

    @Override
    public int getItemCount() {
        if (recipeList == null) {
            return 0;
        }
        return recipeList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private RecipeItemBinding binding;
        OnRecipeListener onRecipeListener;

        public ViewHolder(@NonNull RecipeItemBinding binding, OnRecipeListener onRecipeListener) {
            super(binding.getRoot());
            this.binding = binding;
            this.onRecipeListener = onRecipeListener;

        }

        public void bind(Recipe recipe, OnRecipeListener mOnRecipeListener) {
            binding.setRecipe(recipe);
            //binding.getClickListener();
            binding.setClickListener(mOnRecipeListener);
            binding.executePendingBindings();
        }

        @Override
        public void onClick(View view) {
            onRecipeListener.onRecipeClick(recipeList.get(getAdapterPosition()));
        }
    }
    
    public interface OnRecipeListener {
        void onRecipeClick(Recipe recipe);
    }
}

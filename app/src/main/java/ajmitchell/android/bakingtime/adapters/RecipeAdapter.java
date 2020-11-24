package ajmitchell.android.bakingtime.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ajmitchell.android.bakingtime.R;
import ajmitchell.android.bakingtime.databinding.RecipeItemBinding;
import ajmitchell.android.bakingtime.models.Recipe;
import io.reactivex.rxjava3.core.Observer;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder>  {

    private Context context;
    private List<Recipe> recipeList;
    public OnRecipeListener mOnRecipeListener;

    public RecipeAdapter(Context context, List<Recipe> recipes, Observer<List<Recipe>> onRecipeListener) {
        this.context = context;
        this.recipeList = recipes;
        this.mOnRecipeListener = onRecipeListener;
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
        holder.bind(recipeResults);
    }

    @Override
    public int getItemCount() {
        if (recipeList == null) {
            return 0;
        }
        return recipeList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        OnRecipeListener onRecipeListener;
        public TextView recipe;
        private RecipeItemBinding binding;

        public ViewHolder(@NonNull RecipeItemBinding binding, OnRecipeListener onRecipeListener) {
            super(binding.getRoot());
            this.onRecipeListener = onRecipeListener;
            this.binding = binding;
           // recipe = itemView.findViewById(R.id.recipe_item); // <--- need to data bind this
        }

        public void bind (Recipe recipe) {
            binding.setRecipe(recipe);
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

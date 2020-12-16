package ajmitchell.android.bakingtime.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ajmitchell.android.bakingtime.databinding.IngredientItemBinding;
import ajmitchell.android.bakingtime.models.Ingredient;

public class IngredientAdapter extends RecyclerView.Adapter<IngredientAdapter.ViewHolder> {

    private List<Ingredient> ingredientList;
    Context context;

    public IngredientAdapter(Context context, List<Ingredient> ingredientList) {
        this.context = context;
        this.ingredientList = ingredientList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        IngredientItemBinding ingredientItemBinding = IngredientItemBinding.inflate(inflater, parent, false);
        IngredientAdapter.ViewHolder viewHolder = new IngredientAdapter.ViewHolder(ingredientItemBinding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Ingredient ingredientResults = ingredientList.get(position);
        holder.bind(ingredientResults);
    }

    @Override
    public int getItemCount() {
        if (ingredientList == null) {
            return 0;
        }
        return ingredientList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private IngredientItemBinding binding;

        public ViewHolder(@NonNull IngredientItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Ingredient ingredient) {
            binding.setIngredient(ingredient);
            binding.executePendingBindings();
        }
    }

}

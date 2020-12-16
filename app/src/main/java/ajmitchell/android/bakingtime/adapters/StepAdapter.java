package ajmitchell.android.bakingtime.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ajmitchell.android.bakingtime.databinding.IngredientItemBinding;
import ajmitchell.android.bakingtime.databinding.StepItemBinding;
import ajmitchell.android.bakingtime.models.Ingredient;
import ajmitchell.android.bakingtime.models.Step;

public class StepAdapter extends RecyclerView.Adapter<StepAdapter.ViewHolder> {

    private List<Step> stepList;
    Context context;

    public StepAdapter(Context context, List<Step> stepList) {
        this.context = context;
        this.stepList = stepList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        StepItemBinding stepItemBinding = StepItemBinding.inflate(inflater, parent, false);
        StepAdapter.ViewHolder viewHolder = new StepAdapter.ViewHolder(stepItemBinding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Step stepResults = stepList.get(position);
        holder.bind(stepResults);
    }

    @Override
    public int getItemCount() {
        if (stepList == null){
            return 0;
        }
        return stepList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private StepItemBinding binding;

        public ViewHolder(@NonNull StepItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Step step) {
            binding.setStep(step);
            binding.executePendingBindings();
        }
    }
}

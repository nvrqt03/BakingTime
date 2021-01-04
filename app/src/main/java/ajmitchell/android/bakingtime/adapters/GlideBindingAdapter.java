package ajmitchell.android.bakingtime.adapters;

import android.content.Context;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import ajmitchell.android.bakingtime.R;

// May be unecessary - no image url provided

public class GlideBindingAdapter {
    @BindingAdapter("imageUrl")
    public static void setImage(ImageView view, String imageUrl) {
        Context context = view.getContext();

        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background);

        Glide.with(context)
                .setDefaultRequestOptions(options)
                .load(imageUrl)
                .into(view);
    }
}

package com.example.wallpaper.ui.adapter.recycler.winter;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.wallpaper.R;
import com.example.wallpaper.model.Model;
import com.example.wallpaper.model.ModelGallery;
import com.example.wallpaper.ui.adapter.base.BaseViewHolder;
import com.example.wallpaper.ui.main.WinterFragment;

class WinterViewHolder extends BaseViewHolder<ModelGallery> {

    private ImageView imageView;
    private Button button;

    public WinterViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageWinter);
    }

    @Override
    public void bind(ModelGallery data) {
        Glide.with(imageView).load(data.getUrl())
                .apply(new RequestOptions())
                .transform(new CenterCrop(),
                        new RoundedCorners(10))
                .into(imageView);
    }

    @Override
    public void unbind() {
    }
}

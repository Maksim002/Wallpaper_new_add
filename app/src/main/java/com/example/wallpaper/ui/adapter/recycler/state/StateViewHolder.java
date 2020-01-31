package com.example.wallpaper.ui.adapter.recycler.state;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.wallpaper.R;
import com.example.wallpaper.model.ModelGallery;
import com.example.wallpaper.ui.adapter.base.BaseViewHolder;
import com.example.wallpaper.interfese.Listener;

class StateViewHolder extends BaseViewHolder<ModelGallery> {
    private ImageView imageView;
    private Listener listener;

    public StateViewHolder(@NonNull View itemView, Listener listener) {
        super(itemView);
        this.listener = listener;
        imageView = itemView.findViewById(R.id.imageState);
    }

    @Override
    public void bind(final ModelGallery data) {

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

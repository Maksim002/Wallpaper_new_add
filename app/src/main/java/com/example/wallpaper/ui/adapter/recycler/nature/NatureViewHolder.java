package com.example.wallpaper.ui.adapter.recycler.nature;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.wallpaper.R;
import com.example.wallpaper.model.Model;
import com.example.wallpaper.model.ModelGallery;
import com.example.wallpaper.ui.adapter.base.BaseViewHolder;
import com.example.wallpaper.ui.main.Listener;

import java.io.IOException;

class NatureViewHolder extends BaseViewHolder<ModelGallery> {
    private ImageView imageView,imageViewE;
    private Button button;
    private Listener listener;

    public NatureViewHolder(@NonNull View itemView, Listener listener) {
        super(itemView);
        this.listener = listener;
        imageView = itemView.findViewById(R.id.imageNature);
        button = itemView.findViewById(R.id.buttonNature);
    }

    @Override
    public void bind(final ModelGallery data) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    listener.onClick(getAdapterPosition(),data);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

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

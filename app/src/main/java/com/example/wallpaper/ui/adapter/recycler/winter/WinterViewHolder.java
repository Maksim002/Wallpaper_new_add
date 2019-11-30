package com.example.wallpaper.ui.adapter.recycler.winter;

import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.wallpaper.R;
import com.example.wallpaper.model.ModelGallery;
import com.example.wallpaper.ui.adapter.base.BaseViewHolder;
import com.example.wallpaper.ui.main.Listener;

import java.io.IOException;

class WinterViewHolder extends BaseViewHolder<ModelGallery> {

    private ImageView imageView,imageViewE;
    private Button button;
    private Listener listener;

    private WallpaperManager wallpaperManager;
    private DisplayMetrics displayMetrics;
    private int width, height;
    private Bitmap bitmapE, bitmapB;
    private BitmapDrawable bitmapDrawable;


    public WinterViewHolder(@NonNull View itemView,Listener listener) {
        super(itemView);
        this.listener = listener;
        imageView = itemView.findViewById(R.id.imageWinter);
        button = itemView.findViewById(R.id.buttonWinter);
        imageViewE = itemView.findViewById(R.id.imageYsWinter);
    }

    @Override
    public void bind(final ModelGallery data) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickWinter(getAdapterPosition(),data);
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

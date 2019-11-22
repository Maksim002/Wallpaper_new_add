package com.example.wallpaper.ui.adapter.recycler.winter;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.wallpaper.R;
import com.example.wallpaper.model.Model;
import com.example.wallpaper.ui.adapter.base.BaseViewHolder;

class WinterViewHolder extends BaseViewHolder<Model> {

    private ImageView imageView;
    private Button button;

    public WinterViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageWinter);
    }

    @Override
    public void bind(Model data) {
        imageView.setImageResource(data.getImage());
    }

    @Override
    public void unbind() {
    }
}

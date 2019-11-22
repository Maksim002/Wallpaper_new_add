package com.example.wallpaper.ui.adapter.recycler.other;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.example.wallpaper.R;
import com.example.wallpaper.model.Model;
import com.example.wallpaper.ui.adapter.base.BaseViewHolder;

class OtherViewHolder extends BaseViewHolder<Model> {
    private ImageView imageView;

    public OtherViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageOther);
    }

    @Override
    public void bind(Model data) {
        imageView.setImageResource(data.getImage());
    }

    @Override
    public void unbind() {

    }
}

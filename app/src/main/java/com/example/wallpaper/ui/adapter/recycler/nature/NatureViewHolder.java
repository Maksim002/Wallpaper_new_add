package com.example.wallpaper.ui.adapter.recycler.nature;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.example.wallpaper.R;
import com.example.wallpaper.model.Model;
import com.example.wallpaper.ui.adapter.base.BaseViewHolder;

class NatureViewHolder extends BaseViewHolder<Model> {
    private ImageView imageView;

    public NatureViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.imageNature);
    }

    @Override
    public void bind(Model data) {
        imageView.setImageResource(data.getImage());
    }

    @Override
    public void unbind() {

    }
}

package com.example.wallpaper.ui.main;

import android.view.View;

import com.example.wallpaper.model.ModelGallery;

public interface Listener {

    void onClick(int adapterPosition, ModelGallery data);
}

package com.example.wallpaper.interfese;

import android.view.View;

import com.example.wallpaper.model.ModelGallery;

import java.io.IOException;

public interface Listener {

    void onClick(int adapterPosition, ModelGallery data) throws IOException;
}

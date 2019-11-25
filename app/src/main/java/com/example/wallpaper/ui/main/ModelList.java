package com.example.wallpaper.ui.main;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.wallpaper.model.ModelGallery;

public class ModelList extends WinterFragment implements Listener {

    @Override
    public void onClickWinter(int adapterPosition, ModelGallery data) {
        super.onClickWinter(adapterPosition, data);
        switch (adapterPosition){
            case 1:
                Intent intent = new Intent(getContext(),Tooooooooooop.class);
                startActivity(intent);
                break;
        }
    }
}

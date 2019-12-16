package com.example.wallpaper.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.wallpaper.R;
import com.example.wallpaper.model.ModelGallery;

import java.io.IOException;

public class StateFragment extends Fragment implements Listener {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_state, container, false);
    }

    @Override
    public void onClick(int adapterPosition, ModelGallery data) throws IOException {

    }
}

package com.example.wallpaper.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wallpaper.R;
import com.example.wallpaper.model.HomeModel;
import com.example.wallpaper.model.Model;
import com.example.wallpaper.ui.adapter.recycler.winter.WinterRecyclerAdapter;
import com.example.wallpaper.ui.util.ResourceManager;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class WinterFragment extends Fragment {
    private RecyclerView recyclerView;
    private WinterRecyclerAdapter adapter;
    private String SAMPLES = "test.json";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_winter,container,false);

        recyclerView = view.findViewById(R.id.recyclerWinter);
        recyclerView.setAdapter(adapter = new WinterRecyclerAdapter(getWinter()));
        adapter.updeteList(getWinter());

        return view;
    }
    private List<Model> getWinter(){
        List<Model> models = new ArrayList<>();
        models.add(new Model(R.drawable.nebo));
        models.add(new Model(R.drawable.nebo));
        models.add(new Model(R.drawable.nebo));
        models.add(new Model(R.drawable.nebo));
        models.add(new Model(R.drawable.nebo));
        models.add(new Model(R.drawable.nebo));
        models.add(new Model(R.drawable.nebo));
        models.add(new Model(R.drawable.nebo));
        return models;
    }

}

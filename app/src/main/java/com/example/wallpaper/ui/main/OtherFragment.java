package com.example.wallpaper.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wallpaper.R;
import com.example.wallpaper.model.Model;
import com.example.wallpaper.model.ModelGallery;
import com.example.wallpaper.ui.adapter.recycler.other.OtherRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class OtherFragment extends Fragment implements Listener {
    private RecyclerView recyclerView;
    private OtherRecyclerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_other,container,false);

        recyclerView = view.findViewById(R.id.recyclerOther);
        recyclerView.setAdapter(adapter = new OtherRecyclerAdapter(getOther(),this));
        adapter.updeteList(getOther());

        return view;
    }
    private List<Model> getOther(){
        List<Model> models = new ArrayList<>();
        models.add(new Model(R.drawable.krasivye_kollazh));
        models.add(new Model(R.drawable.krasivye_kollazh));
        models.add(new Model(R.drawable.krasivye_kollazh));
        models.add(new Model(R.drawable.krasivye_kollazh));
        models.add(new Model(R.drawable.krasivye_kollazh));
        return models;
    }
    @Override
    public void onClickWinter(int adapterPosition, ModelGallery data) {

    }
}

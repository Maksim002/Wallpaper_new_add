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
import com.example.wallpaper.ui.adapter.recycler.year.NewYearRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class NewYearFragment extends Fragment {
    private RecyclerView recyclerView;
    private NewYearRecyclerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_new_year,container,false);

        recyclerView = view.findViewById(R.id.recyclerYear);
        recyclerView.setAdapter(adapter = new NewYearRecyclerAdapter(getYear()));
        adapter.updeteList(getYear());
        return view;
    }
    private List<Model> getYear(){
        List<Model> models = new ArrayList<>();
        models.add(new Model(R.drawable.krasivye_kollazh));
        models.add(new Model(R.drawable.krasivye_kollazh));
        models.add(new Model(R.drawable.krasivye_kollazh));
        models.add(new Model(R.drawable.krasivye_kollazh));
        models.add(new Model(R.drawable.krasivye_kollazh));
        return models;
    }
}

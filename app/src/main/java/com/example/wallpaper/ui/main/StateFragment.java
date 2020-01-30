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
import com.example.wallpaper.interfese.Listener;
import com.example.wallpaper.model.Model;
import com.example.wallpaper.model.ModelGallery;
import com.example.wallpaper.ui.adapter.recycler.state.StateRecyclerAdapter;
import com.example.wallpaper.ui.main.password.ActivityPassword;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StateFragment extends Fragment implements Listener {

    private FirebaseDatabase database;
    private DatabaseReference reference;

    private RecyclerView stateRecyclerView;
    private List<ModelGallery> list = new ArrayList<>();
    private StateRecyclerAdapter adapter;
    private Listener listener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_state, container, false);

        stateRecyclerView = view.findViewById(R.id.stateRecyclerView);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("galley").child(ActivityPassword.userId);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try {
                    list = new ArrayList<>();
                    Collection<String> a = dataSnapshot.getValue(new GenericTypeIndicator<Map<String, String>>() {}).values();
                    for (String str : a) {
                        list.add(new ModelGallery(str));
                    }
                    adapter = new StateRecyclerAdapter(list, listener);
                    stateRecyclerView.setAdapter(adapter);
                }catch (Exception e){

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return view;
    }


    @Override
    public void onClick(int adapterPosition, ModelGallery data) throws IOException {

    }
}

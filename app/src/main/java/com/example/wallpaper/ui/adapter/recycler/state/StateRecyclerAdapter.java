package com.example.wallpaper.ui.adapter.recycler.state;

import android.view.View;

import com.example.wallpaper.R;
import com.example.wallpaper.model.ModelGallery;
import com.example.wallpaper.ui.adapter.base.BaseRecyclerAdaptor;
import com.example.wallpaper.interfese.Listener;
import com.example.wallpaper.ui.main.StateFragment;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class StateRecyclerAdapter extends BaseRecyclerAdaptor<StateViewHolder, ModelGallery> {
    private Listener listener;
    private List<ModelGallery> listEN;

    public StateRecyclerAdapter(List<ModelGallery> list, Listener listener) {
        super(list, listener);
        this.listener = listener;
        this.listEN = list;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.item_state;
    }

    @Override
    protected StateViewHolder getViewHolder(View view) {
        return new StateViewHolder(view,listener);
    }
}

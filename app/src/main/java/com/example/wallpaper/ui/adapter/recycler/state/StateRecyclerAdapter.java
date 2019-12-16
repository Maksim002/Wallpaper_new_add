package com.example.wallpaper.ui.adapter.recycler.state;

import android.view.View;

import com.example.wallpaper.R;
import com.example.wallpaper.model.ModelGallery;
import com.example.wallpaper.ui.adapter.base.BaseRecyclerAdaptor;
import com.example.wallpaper.ui.main.Listener;

import java.util.List;

public class StateRecyclerAdapter extends BaseRecyclerAdaptor<StateViewHolder, ModelGallery> {
    private Listener listener;

    public StateRecyclerAdapter(List<ModelGallery> list, Listener listener) {
        super(list,listener);
        this.listener = listener;
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

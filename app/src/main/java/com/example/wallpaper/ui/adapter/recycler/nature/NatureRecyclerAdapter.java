package com.example.wallpaper.ui.adapter.recycler.nature;

import android.view.View;

import com.example.wallpaper.R;
import com.example.wallpaper.model.Model;
import com.example.wallpaper.model.ModelGallery;
import com.example.wallpaper.ui.adapter.base.BaseRecyclerAdaptor;
import com.example.wallpaper.ui.main.Listener;

import java.util.List;

public class NatureRecyclerAdapter extends BaseRecyclerAdaptor<NatureViewHolder, ModelGallery> {
    private Listener listener;

    public NatureRecyclerAdapter(List<ModelGallery> list, Listener listener) {
        super(list,listener);
        this.listener = listener;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.item_nature;
    }

    @Override
    protected NatureViewHolder getViewHolder(View view) {
        return new NatureViewHolder(view,listener);
    }
}

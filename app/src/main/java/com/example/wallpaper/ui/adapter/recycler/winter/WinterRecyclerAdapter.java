package com.example.wallpaper.ui.adapter.recycler.winter;

import android.view.View;

import com.example.wallpaper.R;
import com.example.wallpaper.model.ModelGallery;
import com.example.wallpaper.ui.adapter.base.BaseRecyclerAdaptor;
import com.example.wallpaper.ui.main.Listener;

import java.util.List;

public class WinterRecyclerAdapter extends BaseRecyclerAdaptor<WinterViewHolder, ModelGallery> {
    public WinterRecyclerAdapter(List<ModelGallery> list, Listener listener) {
        super(list,listener);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.item_winter;
    }

    @Override
    protected WinterViewHolder getViewHolder(View view) {
        return new WinterViewHolder(view);
    }
}
